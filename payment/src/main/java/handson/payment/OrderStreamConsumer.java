package handson.payment;

import handson.commons.domain.Topology;
import handson.commons.domain.avro.Order;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;

/**
 * Created by diegoicosta on 26/03/17.
 */
//@Component
public class OrderStreamConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String APP_ID = "order-diego-app.01";
    private static final String KAFKA_URL = "localhost:9092";

    @Bean
    public KafkaStreams buidOrderTopology() {
        Serde<String> keySerde = new Serdes.StringSerde();

        Serde<Order> orderSerde = new SpecificAvroSerde<>();

        final Map<String, String> serdeConfig = Collections
                .singletonMap("schema.registry.url", "http://localhost:8081");

        orderSerde.configure(serdeConfig, false); // `false` for record values

        KStreamBuilder builder = new KStreamBuilder();

        /* @formatter:off */
        builder
                .stream(keySerde, orderSerde, Topology.HANDSON_ORDER.getName())
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
        streamsConfiguration.put("schema.registry.url", "http://localhost:8081");

        return streamsConfiguration;
    }

}
