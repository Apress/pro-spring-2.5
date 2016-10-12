package com.apress.prospring2.ch14.dynamic;

import com.apress.prospring2.ch14.beans.TextSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author janm
 */
public class DynamicDemo {

    public static void main(String[] args) throws IOException {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("dynamic-beans-context.xml", DynamicDemo.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            TextSource textSouce = (TextSource) ac.getBean("textSource");
            System.out.println(textSouce.getMessage());
            System.out.println("Press Enter to continue, exit to stop.");
            if ("exit".equals(reader.readLine())) break;
        }
    }

}
