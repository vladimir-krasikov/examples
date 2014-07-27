package pro.krasikov.service.impl;

import org.springframework.stereotype.Service;
import pro.krasikov.service.Work;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 27.07.2014.
 */

@Service
public class HardWork implements Work {
    @Override
    public void doWork() {
        System.out.println("in hard work");
    }
}
