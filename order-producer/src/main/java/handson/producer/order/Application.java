package handson.producer.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;

/**
 * Created by diegoicosta on 20/03/16.
 */
@SpringBootConfiguration
@ComponentScan({ "moip.financial.balance.*", "moip.kafkautils.*" })
public class Application {

    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        ApplicationContext context = run(Application.class, args);

        try {
            new Producer().produce(1, 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
