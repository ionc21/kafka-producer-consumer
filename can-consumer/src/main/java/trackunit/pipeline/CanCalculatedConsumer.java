package com.pluralsight.weather;

import com.trackunit.pipeline.CalculatedCanActivity;
import com.trackunit.pipeline.CalculatedCanInstance;
import com.trackunit.pipeline.CanActivityState;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.Properties;

public class CanCalculatedConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(CanCalculatedConsumer.class);
    private static final String CAN_TOPIC = "pipeline.machine.can.activity.calculated";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "can.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        props.put(KafkaAvroDeserializerConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        KafkaConsumer<String, CalculatedCanActivity> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(CAN_TOPIC));

        while (true) {
            ConsumerRecords<String, CalculatedCanActivity> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, CalculatedCanActivity> record : records) {
                if (record.value() != null) {
                    printActivity(record.key(), record.value());
                } else {
                    System.out.println("invalid record");
                }
            }
        }
    }

    private static void printActivity(String key, CalculatedCanActivity canActivity) {
        LOG.info(String.format("key: %s  %s %s", key, canActivity.getCAN1().getActivity(),
                Optional.ofNullable(canActivity.getCAN2())
                        .orElse(CalculatedCanInstance.newBuilder().setActivity(CanActivityState.NO_ACTIVITY_DETECTED).build())));
    }

}
