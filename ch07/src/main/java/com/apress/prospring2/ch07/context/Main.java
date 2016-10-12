package com.apress.prospring2.ch07.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context-context.xml", Main.class);
        TestBean testBean = (TestBean)context.getBean("test");
        System.out.println(testBean);
    }
    
}
