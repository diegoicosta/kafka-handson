package handson.producer.order;

import handson.commons.domain.avro.Order;
import handson.commons.domain.avro.Payment;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

import static handson.commons.domain.Builder.buildRandom;
import static handson.commons.domain.Topology.HANDSON_ORDER;
import static handson.commons.domain.Topology.HANDSON_PAYMENT;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

/**
 * Created by diegoicosta on 25/03/17.
 */
public class Producer {

    private KafkaProducer<String, Order> buildOrdeProducer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        props.put(ACKS_CONFIG, "all");
        props.put(RETRIES_CONFIG, 100);
        props.put(BATCH_SIZE_CONFIG, 0);
        Serde<Order> valSerde = new SpecificAvroSerde<>();

        final Map<String, String> serdeConfig = Collections
                .singletonMap("schema.registry.url", "http://localhost:8081");

        valSerde.configure(serdeConfig, false); // `false` for record values

        return new KafkaProducer<>(props, new StringSerializer(), valSerde.serializer());

    }

    private KafkaProducer<String, Payment> buildPaymentProducer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        props.put(ACKS_CONFIG, "all");
        props.put(RETRIES_CONFIG, 100);
        props.put(BATCH_SIZE_CONFIG, 0);
        Serde<Payment> valSerde = new SpecificAvroSerde<>();

        final Map<String, String> serdeConfig = Collections
                .singletonMap("schema.registry.url", "http://localhost:8081");

        valSerde.configure(serdeConfig, false); // `false` for record values

        return new KafkaProducer<>(props, new StringSerializer(), valSerde.serializer());

    }

    public void produce(int wait, int max) throws InterruptedException {

        String[] accounts = { "MPA-0001", "MPA-0002", "MPA-0003", "MPA-0004", "MPA-0005" };

        KafkaProducer<String, Order> ordeProducer = buildOrdeProducer();
        List<Order> ordersId = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            Order order = buildRandom(accounts);
            ordersId.add(order);
            Thread.sleep(wait);
            ProducerRecord record = new ProducerRecord(HANDSON_ORDER.getName(), order.getId(), order);
            ordeProducer.send(record);
        }
        ordeProducer.close();

        KafkaProducer<String, Payment> paymentProducer = buildPaymentProducer();

        for (Order order : ordersId) {
            Payment payment = buildRandom(order);
            Thread.sleep(wait);
            ProducerRecord record = new ProducerRecord(HANDSON_PAYMENT.getName(), payment.getId(), payment);
            paymentProducer.send(record);
        }
        ordeProducer.close();
    }



}
