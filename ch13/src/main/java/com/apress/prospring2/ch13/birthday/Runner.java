package com.apress.prospring2.ch13.birthday;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author anirvanc
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("/com/apress/prospring2/ch13/birthday/birthdayReminder.xml");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
    }
}
