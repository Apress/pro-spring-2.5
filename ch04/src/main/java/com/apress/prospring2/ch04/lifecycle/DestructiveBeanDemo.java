package com.apress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * @author janm
 */
public class DestructiveBeanDemo {

    public static void main(String[] args) throws IOException {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/lifecycledemo5-context.xml"));
        System.out.println(factory.getBean("destructive"));
        new BufferedInputStream(System.in).read();
        factory.destroySingletons();
        System.out.println("Almost done!");
        new BufferedInputStream(System.in).read();
    }

}
