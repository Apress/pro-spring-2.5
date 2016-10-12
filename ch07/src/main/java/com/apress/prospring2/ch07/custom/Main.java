package com.apress.prospring2.ch07.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anirvanc
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("classpath*:**/custom-context.xml");
		Greeter greeter = (Greeter)context.getBean("greeter");
		greeter.greet();

	}
}
