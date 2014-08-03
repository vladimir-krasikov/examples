package pro.krasikov.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pro.krasikov.sample.dao.TaskRepository;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 03.08.2014.
 */
@Configuration
@EnableAutoConfiguration
@EnableCaching
@ComponentScan
public class Main implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    Logger logger = LoggerFactory.getLogger(Main.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("start app");
        logger.info("first task", taskRepository.getByNameContains("first"));
        logger.info("first task", taskRepository.getByNameContains("first"));
        logger.info("second task", taskRepository.getByNameContains("second"));
        logger.info("second task", taskRepository.getByNameContains("second"));
        logger.info("third task", taskRepository.getByNameContains("third"));
        logger.info("third task", taskRepository.getByNameContains("third"));
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("tasks");
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
