package com.apress.prospring2.ch14.groovy;

import com.apress.prospring2.ch14.Checker;
import com.apress.prospring2.ch14.Corrector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class ImplementationDemo {

    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("beans-context.xml", ImplementationDemo.class);
        Object bean = ac.getBean("bean");
        Corrector corrector = (Corrector)bean;
        Checker checker = (Checker)bean;
        String corrected = corrector.correct("foo");
        System.out.println(checker.check(corrected));
    }
}