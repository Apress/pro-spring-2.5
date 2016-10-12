package com.apress.prospring2.ch15.remoting.rmi;

import com.apress.prospring2.ch15.remoting.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aleksav
 */
public class HelloWorldJndiClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/rmi/helloWorldJndiClient.xml");

        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorldService");
        System.out.println(helloWorld.getMessage());

    }
}