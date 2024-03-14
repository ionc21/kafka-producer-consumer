package com.pluralsight.weather;

import com.pluralsight.avro.audio.Device;
import com.pluralsight.avro.audio.Order;
import com.pluralsight.avro.audio.PlaySong;
import com.pluralsight.avro.audio.QueueSong;
import com.pluralsight.avro.weather.City;
import com.pluralsight.avro.weather.Weather;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.subject.RecordNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class SongQueuer {

    private static final Logger LOG = LoggerFactory.getLogger(SongQueuer.class);
    private static final String MUSIC_TOPIC = "music";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, RecordNameStrategy.class.getName());

        KafkaProducer<Device, QueueSong> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        Device key = Device.newBuilder()
                .setId("spk-1")
                .setName("Living Room Speaker")
                .setLocation("Living Room Table")
                .build();

        QueueSong value = QueueSong.newBuilder()
                .setSong("Fur Elise")
                .setArtist("Wolfgang Amadeus Mozart")
                .setOrder(Order.FIRST)
                .build();

        LOG.info("Queuing the " + value.getSong() + " song on the " + key.getName() + " device");

        ProducerRecord<Device, QueueSong> producerRecord =
                new ProducerRecord<>(MUSIC_TOPIC, key, value);
        producer.send(producerRecord);
    }
}
