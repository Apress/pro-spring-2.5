package com.apress.prospring2.ch12.timer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MethodInvokingTimerTaskExample {

    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("com/apress/prospring2/ch12/timer/foobean-context.xml");
        System.in.read();
    }
}
