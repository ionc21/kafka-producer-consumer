package trackunit.pipeline;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import postgres_data_collection_configuration.can_activity.Envelope;
import postgres_data_collection_configuration.can_activity.Key;
import postgres_data_collection_configuration.can_activity.Value;

import java.util.Properties;

public class ConnectorProducer {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectorProducer.class);
    private static final String CAN_TOPIC = "postgres_data_collection_configuration.public.can_activity";
    public static final String UUID = "00000000-0000-0000-0000-000115437888";
    public static final String SERIAL_NUMBER = "536205";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        KafkaProducer<Key, Envelope> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        sendAvroKafkaMessage(createCanActivityReport(), producer);
    }
    private static void sendAvroKafkaMessage(Envelope message, KafkaProducer<Key, Envelope> producer) {
        var key = Key.newBuilder().setCanInstance("CAN_1").setLegacyDeviceSerialNumber(SERIAL_NUMBER).build();
        producer.send(new ProducerRecord<>(CAN_TOPIC, key, message));
        producer.flush();
    }

    private static Envelope createCanActivityReport() {
        long now = System.currentTimeMillis();
        return Envelope.newBuilder()
                .setBefore(null)
                .setAfter(Value.newBuilder()
                        .setAssetId(UUID)
                        .setCanActivityState("NO_ACTIVITY_DETECTED")
                        .setCanInstance("CAN_1")
                        .setCreatedAt(now)
                        .setLegacyDeviceSerialNumber(SERIAL_NUMBER)
                        .build()
                )
                .setOp("u")
                .build();
    }
}
