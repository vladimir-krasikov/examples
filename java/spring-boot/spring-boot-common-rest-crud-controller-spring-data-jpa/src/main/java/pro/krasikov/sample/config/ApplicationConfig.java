package pro.krasikov.sample.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 19.07.2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "pro.krasikov.sample.controller")
@EnableJpaRepositories(basePackages = "pro.krasikov.sample.dao")
@EntityScan(basePackages = "pro.krasikov.sample.domain")
public class ApplicationConfig {

}
