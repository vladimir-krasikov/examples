package pro.krasikov.sample.config;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import pro.krasikov.sample.dao.TaskRepository;
import pro.krasikov.sample.domain.Task;

import java.nio.charset.Charset;

/**
* @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
*         Date: 20.07.2014.
*/
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "pro.krasikov.sample.controller")
@EntityScan(basePackages = "pro.krasikov.sample.domain")
public class TestConfig {

    @Bean
    public TaskRepository taskRepositoryMock() {
        return Mockito.mock(TaskRepository.class);
    }

    @Bean
    public Task firstTask() {
        return new Task("first task", "description one");
    }

    @Bean
    public Task secondTask() {
        return new Task("second task", "description two");
    }

    @Bean
    public MediaType applicationJsonUtf8() {
        return new MediaType(
                MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                Charset.forName("utf8"));
    }
}
