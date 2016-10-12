package com.apress.prospring2.ch15.remoting.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aleksav
 */
public class HelloWorldJndiHost {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/rmi/helloWorldJndi.xml");
        System.out.println("Host Started...");
    }
}
