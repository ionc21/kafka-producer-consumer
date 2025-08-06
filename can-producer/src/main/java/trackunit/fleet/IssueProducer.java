package trackunit.fleet;

import com.trackunit.fleet.data.health.avro.*;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class IssueProducer {

    private static final Logger LOG = LoggerFactory.getLogger(IssueProducer.class);
    private static final String ISSUE_TOPIC = "fleet-data-health-issue";
    public static final String SERIAL_NO = "00000000-0000-0000-0000-000115437888";

    static KafkaProducer<String, FleetDataHealthIssues> producer;
    static KafkaProducer<String, FleetDataHealthIssueIncoming> kafkaTemplate;


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        producer = new KafkaProducer<>(props);
        kafkaTemplate = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);
        produce();

//        sendAvroKafkaMessage(createIssues(), producer);
    }

    private static FleetDataHealthIssues createIssues() {
        return FleetDataHealthIssues.newBuilder()
                .setAssetId("00000000-0000-0000-0000-000002218792")
                .setIssues(List.of()).build();
    }

    private static FleetDataHealthIssue getIssue() {
        return FleetDataHealthIssue.newBuilder()
                .setIssueId(UUID.randomUUID().toString())
                .setState(FleetDataHealthIssueState.OPEN)
                .setCategory(FleetDataHealthIssueCategory.OPERATIONAL_DEVICE_CORE_DEFINITION)
                .setType(FleetDataHealthIssueType.OPERATING_HOURS)
                .build();
    }

    private static void sendAvroKafkaMessage(FleetDataHealthIssues message, KafkaProducer<String, FleetDataHealthIssues> producer) {
        producer.send(new ProducerRecord<>(ISSUE_TOPIC, message.getAssetId().toString(), FleetDataHealthIssues.newBuilder().setIssues(null)
                .setAssetId("00000000-0000-0000-0000-000002218792")
                .build()));
        producer.flush();
    }

    static void produce() {
        int machineId = 720;
        for (int i = 0; i < 1; i++) {
            UUID assetId = UUID.fromString("00000000-0000-0000-0000-000002218792");
            send(FleetDataHealthIssueCategory.OPERATIONAL_DEVICE_CORE_DEFINITION, FleetDataHealthIssueType.OPERATING_HOURS, assetId);
            send(FleetDataHealthIssueCategory.OPERATIONAL_DEVICE_CORE_DEFINITION, FleetDataHealthIssueType.DIGITAL_KEY_DISABLED, assetId);
            send(FleetDataHealthIssueCategory.FUNCTIONAL_DEVICE_CORE_DEFINITION, FleetDataHealthIssueType.LOW_BATTERY_POWER, assetId);
        }
    }

    private static void send(FleetDataHealthIssueCategory issueCategory, FleetDataHealthIssueType issueType, UUID assetId) {
        String topic = "fleet-data-health.issue.incoming";
        FleetDataHealthIssueIncoming message = getFleetDataHealthIssueIncoming(issueCategory, issueType, assetId);
        message.setIssue(null);
        kafkaTemplate.send(new ProducerRecord<>(topic, message.getAssetId().toString(), message));
        System.out.println("Message sent to topic: " + topic + " with payload: " + message);
    }

    private static @NotNull FleetDataHealthIssueIncoming getFleetDataHealthIssueIncoming(FleetDataHealthIssueCategory fleetDataHealthIssueCategory, FleetDataHealthIssueType fleetDataHealthIssueType, UUID assetId) {
        return new FleetDataHealthIssueIncoming(
                assetId.toString(),
                new FleetDataHealthIssue("96912d21-fce8-460c-af0c-61686c9f11b2", fleetDataHealthIssueCategory, fleetDataHealthIssueType, FleetDataHealthIssueState.OPEN, null, Instant.now().toEpochMilli()),
                "manual test"
        );
    }
}


