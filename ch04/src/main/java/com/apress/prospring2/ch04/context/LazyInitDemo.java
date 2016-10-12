package com.apress.prospring2.ch04.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class LazyInitDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "/META-INF/spring/acdemo2-context.xml");

        ctx.getBean("destructiveBean");
    }

}