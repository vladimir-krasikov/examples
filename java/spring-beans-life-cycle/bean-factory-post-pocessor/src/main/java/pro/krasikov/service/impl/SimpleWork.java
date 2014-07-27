package pro.krasikov.service.impl;

import org.springframework.stereotype.Service;
import pro.krasikov.annotation.DeprecatedClass;
import pro.krasikov.service.Work;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 27.07.2014.
 */
@Service
@DeprecatedClass(newImplementation = HardWork.class)
public class SimpleWork implements Work {
    @Override
    public void doWork() {
        System.out.println("in simple work");
    }
}
