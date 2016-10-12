package com.apress.prospring2.ch20.remote.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ProSpring
 */
public class SimpleServerMain {
    public static void main(String[] args) throws Exception {

        new ClassPathXmlApplicationContext(new String[] {
                "server-jmx-context.xml"
        }, SimpleServerMain.class);
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
