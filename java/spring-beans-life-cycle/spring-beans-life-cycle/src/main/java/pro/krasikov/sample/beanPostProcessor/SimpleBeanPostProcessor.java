package pro.krasikov.sample.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Vladimir Krasikov (mailto: vladimir@krasikov.pro)
 *         Date: 27.07.2014.
 */
@Component
public class SimpleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println("BeanPostProcessor: postProcessBeforeInitialization, class: " + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("BeanPostProcessor: postProcessAfterInitialization, class: " + bean.getClass());
        return bean;
    }
}
