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

public class IssueProducerDev {

    private static final Logger LOG = LoggerFactory.getLogger(IssueProducerDev.class);
    private static final String ISSUE_TOPIC = "fleet-data-health-issue";
    public static final String SERIAL_NO = "00000000-0000-0000-0000-000115437888";

    static KafkaProducer<String, FleetDataHealthIssues> producer;
    static KafkaProducer<String, FleetDataHealthIssueIncoming> kafkaTemplate;


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-1.internal.dev.awsapi.trackunit.com:31070,kafka-2.internal.dev.awsapi.trackunit.com:31071,kafka-3.internal.dev.awsapi.trackunit.com:31072");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://internal.dev.awsapi.trackunit.com/schema-registry/");
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
                .setAssetId("00000000-0000-0000-0000-000000527370")
                .setIssues(List.of(getIssue())).build();
    }

    private static FleetDataHealthIssue getIssue() {
        return FleetDataHealthIssue.newBuilder()
                .setIssueId(UUID.randomUUID().toString())
                .setCategory(FleetDataHealthIssueCategory.OPERATIONAL_DEVICE_CORE_DEFINITION)
                .setType(FleetDataHealthIssueType.LOW_BATTERY_POWER)
                .setState(FleetDataHealthIssueState.OPEN)
                .build();
    }

    private static void sendAvroKafkaMessage(FleetDataHealthIssues message, KafkaProducer<String, FleetDataHealthIssues> producer) {
        producer.send(new ProducerRecord<>(ISSUE_TOPIC, message.getAssetId().toString(), message));
        producer.flush();
    }

   static void produce() {
        int machineId = 720;
        for (int i = 0; i < 10; i++) {
            UUID assetId = UUID.fromString("00000000-0000-0000-0000-000000131196");
            send(FleetDataHealthIssueCategory.OPERATIONAL_DEVICE_CORE_DEFINITION, FleetDataHealthIssueType.OPERATING_HOURS, assetId);
            send(FleetDataHealthIssueCategory.OPERATIONAL_DEVICE_CORE_DEFINITION, FleetDataHealthIssueType.DIGITAL_KEY_DISABLED, assetId);
            send(FleetDataHealthIssueCategory.FUNCTIONAL_DEVICE_CORE_DEFINITION, FleetDataHealthIssueType.LOW_BATTERY_POWER, assetId);
        }
    }

    private static void send(FleetDataHealthIssueCategory issueCategory, FleetDataHealthIssueType issueType, UUID assetId) {
        String topic = "fleet-data-health.issue.incoming";
        FleetDataHealthIssueIncoming message = getFleetDataHealthIssueIncoming(issueCategory, issueType, assetId);
        kafkaTemplate.send(new ProducerRecord<>(topic, message.getAssetId().toString(), message));
        System.out.println("Message sent to topic: " + topic + " with payload: " + message);
    }

    private static @NotNull FleetDataHealthIssueIncoming getFleetDataHealthIssueIncoming(FleetDataHealthIssueCategory fleetDataHealthIssueCategory, FleetDataHealthIssueType fleetDataHealthIssueType, UUID assetId) {
        return new FleetDataHealthIssueIncoming(
                assetId.toString(),
                new FleetDataHealthIssue(UUID.randomUUID().toString(), fleetDataHealthIssueCategory, fleetDataHealthIssueType, FleetDataHealthIssueState.OPEN, null, Instant.now().toEpochMilli()),
                "manual test"
        );
    }
}


