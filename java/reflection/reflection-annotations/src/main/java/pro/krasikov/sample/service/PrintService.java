package pro.krasikov.sample.service;

import pro.krasikov.sample.helper.RunOnCreate;

/**
 * @author Vladimir Krasikov
 *         Date: 25.07.2014.
 */
public class PrintService {

    @RunOnCreate
    public void print() {
        System.out.println("RunOnCreate with default count parameter");
    }

    @RunOnCreate(count = 2)
    public void printCount() {
        System.out.println("RunOnCreate with specified count parameter");
    }

    public void doNotPrint() {
        System.out.println("Not work");
    }
}
