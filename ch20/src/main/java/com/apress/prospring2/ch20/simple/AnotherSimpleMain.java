package com.apress.prospring2.ch20.simple;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: anirvanc
 */
public class AnotherSimpleMain {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext(new String[] {
                "another-methodnamebased-jmx-context.xml"
        }, AnotherSimpleMain.class);
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
