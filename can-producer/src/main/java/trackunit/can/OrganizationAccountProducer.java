package trackunit.can;

import com.trackunit.avro.organization.AccountKey;
import com.trackunit.avro.organization.AccountValue;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class OrganizationAccountProducer {

    private static final Logger LOG = LoggerFactory.getLogger(OrganizationAccountProducer.class);
    private static final String CAN_TOPIC = "organization.accounts";

    public static void main(String[] args) {
        var props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(AbstractKafkaSchemaSerDeConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());

        KafkaProducer<AccountKey, AccountValue> producer = new KafkaProducer<>(props);

        Thread shutdownHook = new Thread(producer::close);
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        sendAvroKafkaMessage(createAccountValueMessage(), producer);
    }

    private static void sendAvroKafkaMessage(AccountValue message, KafkaProducer<AccountKey, AccountValue> producer) {
        var key = new AccountKey(message.getId());
        producer.send(new ProducerRecord<>(CAN_TOPIC, key, message));
        producer.flush();
    }

    private static AccountValue createAccountValueMessage() {
        return AccountValue.newBuilder()
                .setId("cc413ef4-c472-4297-8680-2a63d24768f9")
                .setParentId("cc413ef4-c472-4297-8680-2a63d24768f9")
                .setFmsCustomerId(88113)
                .setName("Test Account")
                .setIsExternal(false)
                .setType("organization")
                .build();
    }
}
