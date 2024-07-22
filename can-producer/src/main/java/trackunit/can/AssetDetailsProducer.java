package trackunit.can;

import com.trackunit.can.AssetBrandModelKey;
import com.trackunit.can.AssetDetailsValue;
import com.trackunit.pipeline.*;
import com.trackunit.pipeline.metadata.AssetCanInstance;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class AssetDetailsProducer {

    private static final Logger LOG = LoggerFactory.getLogger(AssetDetailsProducer.class);
    private static final String CAN_TOPIC = "pipeline.machine.can.profiles.suggestions";
    public static final String SERIAL_NO = "00000000-0000-0000-0000-000115437888";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        KafkaProducer<AssetBrandModelKey, AssetDetailsValue> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        sendAvroKafkaMessage(createCanProfileSuggestions(), producer);
    }
    private static void sendAvroKafkaMessage(AssetDetailsValue message, KafkaProducer<AssetBrandModelKey, AssetDetailsValue> producer) {
        var key = new AssetBrandModelKey(message.getBrand(), message.getModel());
        producer.send(new ProducerRecord<>(CAN_TOPIC, key, message));
        producer.flush();
    }

    private static AssetDetailsValue createCanProfileSuggestions() {
        return AssetDetailsValue.newBuilder()
                .setBrand("MANITOU")
                .setModel("Mt 625 h comfort")
                .setType(null)
                .setProductionYearRange(null)
                .setSpecCheckId(null)
                .setCanProfiles(List.of())
                .setMachineInsights(List.of(List.of(), List.of()))
                .setAverageValues(List.of(List.of(), List.of()))
                .build();
    }
}
