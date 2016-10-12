package com.apress.prospring2.ch04.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class AnnotationDemo3 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/annotationdemo4-context.xml"
        );
        HelperDemo hd1 = (HelperDemo) ac.getBean("helperDemo");
        hd1.someOperation();
        System.out.println(hd1);
        HelperDemo hd2 = (HelperDemo) ac.getBean("helperDemo");
        hd2.someOperation();
        System.out.println(hd2);
        Helper helper = (Helper)ac.getBean("helper");
        System.out.println(helper);
    }

}