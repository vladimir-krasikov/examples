package pro.krasikov.sample.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;
import pro.krasikov.sample.annotation.Benchmark;
import pro.krasikov.sample.mBean.BenchmarkController;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 26.07.2014.
 */
@Component
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

    private BenchmarkController controller;

    public BenchmarkBeanPostProcessor() throws Exception {
        controller = new BenchmarkController();
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(controller, new ObjectName("benchmark", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String s) throws BeansException {
        final Class<?> clazz = bean.getClass();
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
                        (objectProxy, methodProxy, args) -> {
                            Method originalMethod =
                                    clazz.getMethod(methodProxy.getName(), methodProxy.getParameterTypes());
                            if (originalMethod.isAnnotationPresent(Benchmark.class) && controller.isEnabled()) {
                                System.out.println("*** Benchmark ***");
                                System.out.println("Method: " + originalMethod);
                                long before = System.nanoTime();
                                Object result = originalMethod.invoke(bean, args);
                                long after = System.nanoTime();
                                double total = ((double) after - before) / 1000000000;
                                System.out.format("execution time : %f seconds", total);
                                System.out.println("\n*** Benchmark ***");
                                return result;
                            } else {
                                return originalMethod.invoke(bean, args);
                            }
                        });
            }
        }
        return bean;
    }
}
