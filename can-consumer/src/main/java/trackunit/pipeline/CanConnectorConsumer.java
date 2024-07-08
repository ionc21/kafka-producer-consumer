package trackunit.pipeline;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import postgres_data_collection_configuration.can_activity.Envelope;
import postgres_data_collection_configuration.can_activity.Key;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY;
import static io.confluent.kafka.serializers.KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG;

public class CanConnectorConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(CanConnectorConsumer.class);
    private static final String CAN_TOPIC = "postgres_data_collection_configuration.public.can_activity";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "can.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(SPECIFIC_AVRO_READER_CONFIG, true);
        props.put(VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        KafkaConsumer<Key, Envelope> consumer = new KafkaConsumer<>(props);

        Thread shutdownHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        consumer.subscribe(Collections.singletonList(CAN_TOPIC));

        while (true) {
            ConsumerRecords<Key, Envelope> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<Key, Envelope> record : records) {
                if (record.value() != null) {
                    printActivity(record.key().getLegacyDeviceSerialNumber().toString(),
                            record.value().getAfter().getCanActivityState().toString());
                } else {
                    System.out.println("invalid record");
                }
            }
        }
    }

    private static void printActivity(String key, String canActivity) {
        LOG.info(String.format("key: %s  value: %s ", key, canActivity));
    }

}
