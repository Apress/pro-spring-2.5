package com.apress.prospring2.ch14.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class PerformanceDemo {
    private ApplicationContext applicationContext;

    private void run() {
        this.applicationContext =
                new ClassPathXmlApplicationContext("beans-context.xml", BeansDemo.class);
        measure("bshTextSource");
        measure("textSource");
        measure("jrubyTextSource");
        measure("javaTextSource");
    }

    private void measure(String beanName) {
        TextSource ts = (TextSource) this.applicationContext.getBean(beanName);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ts.getMessage();
        }
        System.out.println("Bean " + beanName + " took " + (System.currentTimeMillis() - start) + " ms.");
    }

    public static void main(String[] args) {
        new PerformanceDemo().run();
    }
}
