package pro.krasikov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pro.krasikov.service.Worker;

import java.util.List;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 27.07.2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Main implements CommandLineRunner {
    @Autowired
    private List<Worker> workers;

    @Override
    public void run(String... strings) throws Exception {
        workers.forEach(Worker::doWork);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
