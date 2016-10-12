package com.apress.prospring2.ch20.notification;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Console;

/**
 * @author anirvanc
 */
public class SimpleMain {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
				"notification-jmx-context.xml"
		}, SimpleMain.class);
		//new BufferedReader(new InputStreamReader(System.in)).readLine();
		//noinspection CastToConcreteClass
		SimpleSpringBean simpleSpringBean = (SimpleSpringBean) context.getBean("simpleObject");
		final Console systemConsole = System.console();
		if ( systemConsole != null )
		{
			final String terminateLoop = "exit";
			String choice = null;
			do
			{
				systemConsole.printf("Enter a choice: ");
				choice = systemConsole.readLine();
				if ( choice != null && !choice.isEmpty() )
				{
					simpleSpringBean.setSomeValue(choice);
				}
			}
			while (   choice != null
					&& !choice.isEmpty()
					&& !choice.equals(terminateLoop) );
		}
		else
		{
			System.err.println(
					"Please run this in an environment with a system console.");
		}
		context.close();
	}
}

