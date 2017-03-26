package handson.producer.order;

import handson.commons.domain.Order;
import handson.commons.domain.Topology;
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

        String[] accounts = { "MPA-0001", "MPA-0002", "MPA-0003", "MPA-0004", "MPA-0005" };

        KafkaProducer<String, Order> producer = buildOrdeProducer();

        for (int i = 0; i < max; i++) {
            Order order = Order.buildRandom(accounts);
            Thread.sleep(wait);
            ProducerRecord record = new ProducerRecord(Topology.HANDSON_ORDER.getName(), order.getId(), order);
            producer.send(record);
        }
        producer.close();
    }

}
