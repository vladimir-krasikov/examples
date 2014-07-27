package pro.krasikov.sample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pro.krasikov.sample.config.ApplicationConfig;
import pro.krasikov.sample.service.TestService;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 26.07.2014.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        TestService testService = context.getBean(TestService.class);
        while (true) {
            testService.doWork();
            testService.doWork("Hello!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
