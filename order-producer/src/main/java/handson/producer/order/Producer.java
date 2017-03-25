package handson.producer.order;

import moip.kafkautils.serde.GsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

/**
 * Created by diegoicosta on 25/03/17.
 */
public class Producer {

    private static final String TOPIC = "handson.order";

    private KafkaProducer<String, Order> buildOrdeProducer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put("schema.registry.url", "http://localhost:8081");

        props.put(ACKS_CONFIG, "all");
        props.put(RETRIES_CONFIG, 100);
        props.put(BATCH_SIZE_CONFIG, 0);

        return new KafkaProducer<>(props, new StringSerializer(), new GsonSerializer<>());

    }

    public void produce(int wait, int max) throws InterruptedException {

        KafkaProducer<String, Order> producer = buildOrdeProducer();

        for (int i = 0; i < max; i++) {

            Order order = new Order();
            order.setId("ORD-01" + i);
            Thread.sleep(wait * 1000L);

            ProducerRecord record = new ProducerRecord(TOPIC, order.getId(), order);
            producer.send(record);
        }
        producer.close();
    }

}
