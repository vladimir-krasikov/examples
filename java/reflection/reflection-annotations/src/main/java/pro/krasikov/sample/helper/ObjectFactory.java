package pro.krasikov.sample.helper;

import java.lang.reflect.Method;

/**
 * @author Vladimir Krasikov
 *         Date: 25.07.2014.
 */
public class ObjectFactory {

    private ObjectFactory() {
    }

    public static <T> T createObject(Class<T> type) throws Exception {
        T t = type.newInstance();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            RunOnCreate annotation = method.getAnnotation(RunOnCreate.class);
            if (annotation != null) {
                for (int i = 0; i < annotation.count(); i++) {
                    method.invoke(t);
                }
            }
        }
        return t;
    }
}
