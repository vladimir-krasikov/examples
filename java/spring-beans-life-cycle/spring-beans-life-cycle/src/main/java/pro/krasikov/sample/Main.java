package pro.krasikov.sample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pro.krasikov.sample.config.ApplicationConfig;
import pro.krasikov.sample.service.Worker;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 27.07.2014.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Worker worker = context.getBean(Worker.class);
        worker.doWork();
        context.close();
    }
}
