package handson.payment;

import handson.commons.domain.avro.Order;
import moip.kafkautils.serde.GenericJsonSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

import static org.apache.kafka.streams.StreamsConfig.*;

/**
 * Created by diegoicosta on 26/03/17.
 */
//@Component
public class PaymentCDCStream {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String APP_ID = "cdc-bi-app.02";
    private static final String KAFKA_URL = "localhost:9092";
    private static final String ZOOKEEPER_URL = "localhost:2181";

    @Bean
    public KafkaStreams buidCDCTopology() {
        Serde<String> keySerde = new Serdes.StringSerde();
        GenericJsonSerde<Order> orderSerde = new GenericJsonSerde<>(Order.class);

        KStreamBuilder builder = new KStreamBuilder();

        /* @formatter:off */
        builder
                .stream(keySerde, orderSerde, "paycom-order")
                //.filter((s, order) -> order.getStatus().equals(Order.Status.CREATED))
                .map((s, s2) -> KeyValue.pair("NO-KEY", s2))
                .print();

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
        streamsConfiguration.put(ZOOKEEPER_CONNECT_CONFIG, ZOOKEEPER_URL);
        streamsConfiguration.put("schema.registry.url", "http://localhost:8081");

        return streamsConfiguration;
    }

}
