package com.apress.prospring2.ch08.errorreporting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

/**
 * @author janm
 */
public class ErrorReportingDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("error-reporting-context2.xml", ErrorReportingDemo.class);
        ErrorLogDao errorLogDao = (ErrorLogDao)ac.getBean("errorLogDao");
        SimpleClient client = (SimpleClient)ac.getBean("client");
        for (int i = 0; i < 1000; i++) {
            client.uploadTerrible();
            client.uploadBetter();
        }
        System.out.println(errorLogDao.getAll());
    }

}
