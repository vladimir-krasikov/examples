package pro.krasikov.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 19.07.2014.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "pro.krasikov.sample")
@PropertySource("classpath:messages.properties")
public class ApplicationConfig {

    @Value("${hello}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }

    @Bean
    public String getMessage() {
        return message;
    }
}
