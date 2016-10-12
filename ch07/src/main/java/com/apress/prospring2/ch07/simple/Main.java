package com.apress.prospring2.ch07.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author anirvanc
 */
public class Main {

    private void run() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/simple-context.xml");

        List y = (List)context.getBean("Y");
        printList(y);

        Map z = (Map)context.getBean("Z");
        printMap(z);

        Map p = (Map)context.getBean("P");
        printMap(p);
    }

    private void printMap(Map z) {
        for (Object o : z.entrySet()) {
            Map.Entry e = (Map.Entry)o;
            System.out.println(e.getKey() + " => " + e.getValue().getClass() + " " + e.getValue());
        }
    }

    private void printList(List y) {
        for (Object o : y) {
            System.out.println(o.getClass() + " " + o);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
