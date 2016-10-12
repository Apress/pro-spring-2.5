package com.apress.prospring2.ch12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author janm
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("/com/apress/prospring2/ch12/*-context.xml");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
    }

}
