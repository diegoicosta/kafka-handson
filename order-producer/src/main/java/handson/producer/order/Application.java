package handson.producer.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;

import static org.springframework.boot.SpringApplication.run;

/**
 * Created by diegoicosta on 20/03/16.
 */
@SpringBootConfiguration
public class Application {

    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        run(Application.class, args);

        try {
            new Producer().produce(500, 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
