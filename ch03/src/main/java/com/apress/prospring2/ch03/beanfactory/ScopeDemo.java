package com.apress.prospring2.ch03.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class ScopeDemo {

    private static void compare(final BeanFactory factory, final String beanName) {
        String b1 = (String)factory.getBean(beanName);
        String b2 = (String)factory.getBean(beanName);
        System.out.println("Bean b1=" + b1 + ", b2=" + b2);
        System.out.println("Same?  " + (b1 == b2));
        System.out.println("Equal? " + (b1.equals(b2)));
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(
                            new ClassPathResource("/META-INF/spring/beanscopedemo1-context.xml"));
        compare(factory, "singleMe");
        compare(factory, "prototypeMe");
        compare(factory, "requestMe");
    }

}