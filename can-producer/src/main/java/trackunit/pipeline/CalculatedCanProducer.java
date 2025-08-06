package trackunit.pipeline;

import com.trackunit.pipeline.CalculatedCanActivity;
import com.trackunit.pipeline.CalculatedCanInstance;
import com.trackunit.pipeline.CanActivityState;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class CalculatedCanProducer {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatedCanProducer.class);
    private static final String CAN_TOPIC = "pipeline.machine.can.activity.calculated";
    public static final String UUID = "00000000-0000-0000-0000-000115437888";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        KafkaProducer<String, CalculatedCanActivity> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        sendAvroKafkaMessage(createCanActivityReport(), producer);
    }
    private static void sendAvroKafkaMessage(CalculatedCanActivity message, KafkaProducer<String, CalculatedCanActivity> producer) {
        producer.send(new ProducerRecord<>(CAN_TOPIC, UUID, message));
        producer.flush();
    }

    private static CalculatedCanActivity createCanActivityReport() {
        long now = System.currentTimeMillis();
        return CalculatedCanActivity.newBuilder()
                .setAssetId(UUID)
                .setHardwareSerialNumber("5003705")
                .setCAN1(CalculatedCanInstance.newBuilder()
                        .setActivity(CanActivityState.ACTIVITY_DETECTED)
                        .setUpdatedAt(now)
                        .build())
                .setCAN2(CalculatedCanInstance.newBuilder()
                        .setActivity(CanActivityState.NO_ACTIVITY_DETECTED)
                        .setUpdatedAt(now)
                        .build())
                .build();
    }
}
