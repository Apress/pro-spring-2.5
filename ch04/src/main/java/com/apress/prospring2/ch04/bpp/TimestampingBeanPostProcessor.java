package com.apress.prospring2.ch04.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author janm
 */
public class TimestampingBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                field.set(bean, new Date());
            }
        }, new ReflectionUtils.FieldFilter() {
            public boolean matches(Field field) {
                return field.getType() == Date.class &&
                        field.getAnnotation(Timestamp.class) != null;
            }
        });
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
