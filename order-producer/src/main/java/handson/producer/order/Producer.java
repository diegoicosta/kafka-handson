package handson.producer.order;

import handson.commons.domain.IdBuilder;
import handson.commons.domain.Topology;
import handson.commons.domain.avro.Order;
import handson.commons.domain.avro.OrderStatus;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

/**
 * Created by diegoicosta on 25/03/17.
 */
public class Producer {

    private KafkaProducer<String, Order> buildOrdeProducer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // props.put("schema.registry.url", "http://localhost:8081");

        props.put(ACKS_CONFIG, "all");
        props.put(RETRIES_CONFIG, 100);
        props.put(BATCH_SIZE_CONFIG, 0);
        Serde<Order> valSerde = new SpecificAvroSerde<>();

        final Map<String, String> serdeConfig = Collections
                .singletonMap("schema.registry.url", "http://localhost:8081");

        valSerde.configure(serdeConfig, false); // `false` for record values

        return new KafkaProducer<>(props, new StringSerializer(), valSerde.serializer());

    }

    public void produce(int wait, int max) throws InterruptedException {

        String[] accounts = { "MPA-0001", "MPA-0002", "MPA-0003", "MPA-0004", "MPA-0005" };

        KafkaProducer<String, Order> producer = buildOrdeProducer();

        for (int i = 0; i < max; i++) {
            Order order = buildRandom(accounts);
            Thread.sleep(wait);
            ProducerRecord record = new ProducerRecord(Topology.HANDSON_ORDER.getName(), order.getId(), order);
            producer.send(record);
        }
        producer.close();
    }

    public Order buildRandom(String[] accounts) {
        Random random = new Random();

        Order order = new Order();
        String mpa = accounts[random.nextInt(5)];
        order.setAccountId(mpa);
        order.setAmount(((Integer) random.nextInt(10000)).longValue());
        order.setCreatedAt(ZonedDateTime.now().toEpochSecond());
        order.setStatus(OrderStatus.CREATED);
        order.setId(IdBuilder.generate("ORD"));
        return order;
    }

}
