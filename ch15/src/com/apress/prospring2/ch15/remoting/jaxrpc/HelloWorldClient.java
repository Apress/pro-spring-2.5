package com.apress.prospring2.ch15.remoting.jaxrpc;

import com.apress.prospring2.ch15.remoting.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * @author aleksav
 */
public class HelloWorldClient {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/jaxrpc/client.xml");

        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorldService");
        System.out.println(helloWorld.getMessage());
    }
}
