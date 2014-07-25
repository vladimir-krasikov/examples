package pro.krasikov.sample;

import pro.krasikov.sample.helper.ObjectFactory;
import pro.krasikov.sample.service.PrintService;

/**
 * @author Vladimir Krasikov
 *         Date: 25.07.2014.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        PrintService object = ObjectFactory.createObject(PrintService.class);
    }
}
