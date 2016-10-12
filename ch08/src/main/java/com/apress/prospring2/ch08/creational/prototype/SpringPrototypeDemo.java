package com.apress.prospring2.ch08.creational.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class SpringPrototypeDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("prototype-context.xml", SpringPrototypeDemo.class);
        SpringPrototypeClient client = (SpringPrototypeClient) context.getBean("prototypeClient");
        client.run();
    }
}
