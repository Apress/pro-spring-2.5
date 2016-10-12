package com.apress.prospring2.ch14.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class BeansDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-context-dtd.xml", BeansDemo.class);
        TextSource textSouce = (TextSource) ac.getBean("textSource");
        System.out.println(textSouce);
        System.out.println(textSouce.getMessage());
    }

}
