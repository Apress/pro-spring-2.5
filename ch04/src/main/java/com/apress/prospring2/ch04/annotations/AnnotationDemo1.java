package com.apress.prospring2.ch04.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class AnnotationDemo1 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/annotationdemo1-context.xml"
        );
        System.out.println(ac.getBean("simplestBean"));
    }

}
