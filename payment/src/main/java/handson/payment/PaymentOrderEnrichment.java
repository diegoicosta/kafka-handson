package handson.payment;

import handson.commons.domain.Builder;
import handson.commons.domain.avro.Order;
import handson.commons.domain.avro.Payment;
import handson.commons.domain.avro.PaymentFull;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import static handson.commons.domain.Topology.HANDSON_ORDER;
import static handson.commons.domain.Topology.HANDSON_PAYMENT;
import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;

/**
 * Created by diegoicosta on 26/03/17.
 */
@Component
public class PaymentOrderEnrichment {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String APP_ID = "order-enrich-app.01";
    private static final String KAFKA_URL = "localhost:9092";

    @Bean
    public KafkaStreams buildPaymentOrderEnrichmentTopology() {
        Serde<String> keySerde = new Serdes.StringSerde();

        Serde<Order> orderSerde = new SpecificAvroSerde<>();
        Serde<Payment> paymentSerde = new SpecificAvroSerde<>();
        Serde<PaymentFull> paymentFullSerde = new SpecificAvroSerde<>();

        final Map<String, String> serdeConfig = Collections
                .singletonMap("schema.registry.url", "http://localhost:8081");

        orderSerde.configure(serdeConfig, false); // `false` for record values
        paymentSerde.configure(serdeConfig, false); // `false` for record values
        paymentFullSerde.configure(serdeConfig, false); // `false` for record values

        KStreamBuilder builder = new KStreamBuilder();

        /* @formatter:off */
        GlobalKTable<String, Order> orders = builder.globalTable(keySerde, orderSerde,
                HANDSON_ORDER.getName(),
                HANDSON_ORDER.getName() + ".store");
        /* @formatter:on */

        /* @formatter:off */
         builder
            .stream(keySerde, paymentSerde, HANDSON_PAYMENT.getName())
            .join(orders, (s, payment) -> payment.getProductId().toString(),
                    (payment, order) -> Builder.buildPaymentFull(payment,order))
            .to(keySerde, paymentFullSerde,  HANDSON_PAYMENT.getName() + ".full");
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
