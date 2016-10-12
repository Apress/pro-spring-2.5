package com.apress.prospring2.ch03.beandependency;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class DependencyDemo {

    public static void main(String[] args) {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/beandependencydemo1-context.xml"));

        B b = (B) bf.getBean("b");
        A a = (A) bf.getBean("a");
        System.out.println(a);
        System.out.println(b);
    }

}
