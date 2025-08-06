package trackunit.pipeline;

import com.trackunit.pipeline.CanActivityAvro;
import com.trackunit.pipeline.CanActivityStateAvro;
import com.trackunit.pipeline.CanInstance;
import com.trackunit.pipeline.metadata.AssetCanInstance;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Properties;

public class CanProducer {
    private static final String CAN_TOPIC = "pipeline.machine.can.activity.v2";
    public static final String SERIAL_NO = "00000000-0000-0000-0000-000115437888";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        KafkaProducer<AssetCanInstance, CanActivityAvro> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        sendAvroKafkaMessage(createCanActivityReport(), producer);
    }
    private static void sendAvroKafkaMessage(CanActivityAvro message, KafkaProducer<AssetCanInstance, CanActivityAvro> producer) {
        var key = new AssetCanInstance(message.getAssetId(), message.getCanInstance().name());
        producer.send(new ProducerRecord<>(CAN_TOPIC, key, message));
        producer.flush();
    }

    private static CanActivityAvro createCanActivityReport() {
        long now = System.currentTimeMillis();
        return CanActivityAvro.newBuilder()
                .setHardwareSerialNumber("5003705")
                .setActivity(CanActivityStateAvro.ACTIVITY_DETECTED)
                .setAssetId(SERIAL_NO)
                .setCanInstance(CanInstance.CAN_1)
                .setTime(now)
                .setReceivedAt(now)
                .build();
    }
}
