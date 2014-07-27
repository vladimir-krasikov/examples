package pro.krasikov.sample.service.impl;

import org.springframework.stereotype.Service;
import pro.krasikov.sample.service.Worker;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 27.07.2014.
 */
@Service
public class WorkerImpl implements Worker {

    public WorkerImpl() {
        System.out.println("WorkerImpl: constructor");
    }

    @Override
    public void doWork() {
        System.out.println("WorkerImpl: doWork");
    }

    @PostConstruct
    public void init() {
        System.out.println("WorkerImpl: @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("WorkerImpl: @PreDestroy");
    }
}
