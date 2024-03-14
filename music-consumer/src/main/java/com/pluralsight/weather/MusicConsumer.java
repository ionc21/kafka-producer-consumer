package com.pluralsight.weather;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import com.pluralsight.avro.audio.Action;
import com.pluralsight.avro.audio.Device;
import com.pluralsight.avro.audio.PlaySong;
import com.pluralsight.avro.audio.QueueSong;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.subject.RecordNameStrategy;

public class MusicConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MusicConsumer.class);
    private static final String MUSIC_TOPIC = "music";

    private static Boolean isPlaying = false;

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "music.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        props.put(KafkaAvroDeserializerConfig.VALUE_SUBJECT_NAME_STRATEGY, RecordNameStrategy.class.getName());

        KafkaConsumer<Device, GenericRecord> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(MUSIC_TOPIC));

        while(true) {
            ConsumerRecords<Device, GenericRecord> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<Device, GenericRecord> record : records) {
                if(record.value() instanceof PlaySong) {
                    playSong(record.key(), (PlaySong) record.value() );
                } else if(record.value() instanceof QueueSong) {
                    queueSong(record.key(), (QueueSong) record.value());
                }
            }
        }
    }

    private static void playSong(Device device, PlaySong playSong) {
        isPlaying = isPlayingAction(playSong);
        LOG.info(playSong.getAction() + " " + playSong.getSong() + " song on the " 
                    + device.getName() + " device with sound level " + device.getLevel());
    }

    private static void queueSong(Device device,QueueSong queueSong) {
        if(!isPlaying) {
            PlaySong playSong = PlaySong.newBuilder()
                    .setAction(Action.PLAY)
                    .setSong(queueSong.getSong())
                    .setArtist(queueSong.getArtist())
                    .build();
            playSong(device, playSong);
        } else {
            LOG.info("Queueing " + queueSong.getSong() + " song on the " + device.getName() + " device");
        }
    }

    private static boolean isPlayingAction(PlaySong playSong) {
        return Action.PLAY.equals(playSong.getAction()) || Action.RESUME.equals(playSong.getAction());
    }
}
