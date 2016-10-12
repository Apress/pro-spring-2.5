package com.apress.prospring2.ch20.methodnamebased;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author anirvanc
 */
public class SimpleMain {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext(new String[] {
                "methodnamebased-jmx-context.xml"
        }, SimpleMain.class);
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
