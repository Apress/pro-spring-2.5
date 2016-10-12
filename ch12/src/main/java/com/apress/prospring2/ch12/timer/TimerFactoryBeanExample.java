package com.apress.prospring2.ch12.timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TimerFactoryBeanExample {

	public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext(
                "com/apress/prospring2/ch12/timer/timer-context.xml");
		System.in.read();
	}
}
