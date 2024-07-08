package trackunit.pipeline;

import com.trackunit.pipeline.*;
import com.trackunit.pipeline.metadata.AssetCanInstance;
import io.confluent.kafka.serializers.*;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.*;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY;
import static io.confluent.kafka.serializers.KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG;

public class CanCalculatedConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(CanCalculatedConsumer.class);
    private static final String CAN_TOPIC = "pipeline.machine.can.activity.calculated";

    private KafkaProducer<AssetCanInstance, CanActivityAvro> producer;

    @PostConstruct
    void initProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

      producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "can.consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(SPECIFIC_AVRO_READER_CONFIG, true);
        props.put(VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);

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
                Optional.ofNullable(canActivity.getCAN2()).map(CalculatedCanInstance::getActivity).orElse(null)));
    }

}
