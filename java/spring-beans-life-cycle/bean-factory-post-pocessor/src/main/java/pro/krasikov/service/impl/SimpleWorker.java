package pro.krasikov.service.impl;

import org.springframework.stereotype.Service;
import pro.krasikov.annotation.DeprecatedClass;
import pro.krasikov.service.Worker;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 27.07.2014.
 */
@Service
@DeprecatedClass(newImplementation = HardWorker.class)
public class SimpleWorker implements Worker {
    @Override
    public void doWork() {
        System.out.println("in simple work");
    }
}
