package handson.payment;

import handson.commons.domain.Builder;
import handson.commons.domain.Topology;
import handson.commons.domain.avro.Order;
import handson.commons.domain.avro.OrderStatus;
import handson.commons.domain.avro.Payment;
import moip.kafkautils.serde.GenericJsonSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;

/**
 * Created by diegoicosta on 26/03/17.
 */
//@Component
public class OrderStreamConsumer2 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String APP_ID = "order-diego-1-app.01";
    private static final String KAFKA_URL = "localhost:9092";
    private static final String ZOOKEEPER_URL = "localhost:2181";

    @Bean
    public KafkaStreams buidOrderTopology2() {
        Serde<String> keySerde = new Serdes.StringSerde();
        GenericJsonSerde<Order> orderSerde = new GenericJsonSerde<>(Order.class);
        GenericJsonSerde<Payment> paymentSerde = new GenericJsonSerde<>(Payment.class);

        KStreamBuilder builder = new KStreamBuilder();

        /* @formatter:off */
        builder
                .stream(keySerde, orderSerde, Topology.HANDSON_ORDER.getName())
                .filter((s, order) -> order.getStatus().equals(OrderStatus.CREATED))
                .transform(() -> new OrderTransformer() )
                .to(keySerde,paymentSerde,Topology.HANDSON_PAYMENT.getName());
        /* @formatter:on */

        KafkaStreams streams = new KafkaStreams(builder, getKafkaProperties());

        streams.start();

        streams.setUncaughtExceptionHandler((t, e) -> {
            logger.error("Error", e);
        });
        return streams;
    }

    private Properties getKafkaProperties() {

        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(APPLICATION_ID_CONFIG, APP_ID);
        streamsConfiguration.put(BOOTSTRAP_SERVERS_CONFIG, KAFKA_URL);
        streamsConfiguration.put("schema.registry.url", "http://localhost:8081");

        return streamsConfiguration;
    }

    public class OrderTransformer implements Transformer<String, Order, KeyValue<String, Payment>> {

        @Override
        public void init(ProcessorContext processorContext) {
        }

        @Override
        public KeyValue<String, Payment> transform(String key, Order order) {
            Payment payment = Builder.buildRandom(order);
            return new KeyValue(payment.getId(), payment);
        }

        @Override
        public KeyValue<String, Payment> punctuate(long l) {
            return null;
        }

        @Override
        public void close() {
        }
    }

}
