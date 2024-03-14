package com.pluralsight.weather;

import com.pluralsight.avro.audio.Action;
import com.pluralsight.avro.audio.Device;
import com.pluralsight.avro.audio.PlaySong;
import io.confluent.kafka.serializers.subject.RecordNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

import java.util.Properties;

public class SongPlayer {

    private static final Logger LOG = LoggerFactory.getLogger(SongPlayer.class);
    private static final String MUSIC_TOPIC = "music";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, RecordNameStrategy.class.getName());

        KafkaProducer<Device, PlaySong> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        Device device = Device.newBuilder()
                .setId("spk-1")
                .setName("Living Room Speaker")
                .setLocation("Living Room Table")
                .setLevel(10)
                .build();

        PlaySong song = PlaySong.newBuilder()
                .setSong("Old Town Road")
                .setArtist("Lil Nas X")
                .setAction(Action.PLAY)
                .build();

        LOG.info(song.getAction() + " the " + song.getSong() + " song on the " + device.getName() + " device");

        ProducerRecord<Device, PlaySong> producerRecord =
                new ProducerRecord<>(MUSIC_TOPIC, device, song);
        producer.send(producerRecord);
    }
}
