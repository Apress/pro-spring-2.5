package com.apress.prospring2.ch06.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class LoggingAspectDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/ataspectjdemo1-context.xml"
        );
        TestBean testBean = (TestBean) ac.getBean("test");
        testBean.work();
        testBean.stop();
    }

}
