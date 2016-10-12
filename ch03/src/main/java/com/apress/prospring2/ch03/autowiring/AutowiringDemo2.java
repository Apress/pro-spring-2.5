package com.apress.prospring2.ch03.autowiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class AutowiringDemo2 {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("/META-INF/spring/autowiringdemo2-context.xml");

        autowire(bf, "annotatedTarget");
    }

    private static void autowire(BeanFactory factory, String beanName) {
        System.out.println(beanName + ":");
        System.out.println(factory.getBean(beanName));
        System.out.println();
    }
}