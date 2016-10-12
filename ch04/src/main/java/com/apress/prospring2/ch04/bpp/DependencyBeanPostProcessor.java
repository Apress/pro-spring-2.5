package com.apress.prospring2.ch04.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author janm
 */
public class DependencyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean.getClass().equals(Dependency.class)) {
            return "Hello, world";
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}