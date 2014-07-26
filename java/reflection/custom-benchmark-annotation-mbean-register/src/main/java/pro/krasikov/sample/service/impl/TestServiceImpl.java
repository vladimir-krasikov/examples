package pro.krasikov.sample.service.impl;

import org.springframework.stereotype.Component;
import pro.krasikov.sample.annotation.Benchmark;
import pro.krasikov.sample.service.TestService;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 26.07.2014.
 */
@Component
public class TestServiceImpl implements TestService {

    @Benchmark
    @Override
    public void doWork() {
        System.out.println("in doWork() method");
    }

    @Benchmark
    @Override
    public void doWork(String text) {
        System.out.format("in doWork( %s ) method", text);
    }
}
