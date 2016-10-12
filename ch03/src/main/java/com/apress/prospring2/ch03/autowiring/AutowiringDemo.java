package com.apress.prospring2.ch03.autowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class AutowiringDemo {

    public static void main(String[] args) {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/autowiringdemo1-context.xml"));

        autowire(bf, "byName");
        autowire(bf, "byType");
        autowire(bf, "constructor");
        autowire(bf, "autodetect");
    }

    private static void autowire(BeanFactory factory, String beanName) {
        System.out.println(beanName + ":");
        System.out.println(factory.getBean(beanName));
        System.out.println();
    }
}
