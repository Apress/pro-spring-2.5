package com.apress.prospring2.ch08.scheduling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author janm
 */
public class Main {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext(new String[] {
                "scheduler-context.xml",
                "main-context.xml"
        }, Main.class);
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}
