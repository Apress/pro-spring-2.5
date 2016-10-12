package com.apress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * @author janm
 */
public class ShutdownHookDemo {

    public static void main(String[] args) throws IOException {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/lifecycledemo5-context.xml"));
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook(factory)));
        new BufferedInputStream(System.in).read();
    }

}