package com.apress.prospring2.ch15.remoting.rmi;

import com.apress.prospring2.ch15.remoting.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author aleksav
 */
public class HelloWorldClient {

    private HelloWorld helloWorldService;

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/rmi/helloWorldClient.xml");

        HelloWorldClient helloWorldClient = (HelloWorldClient) ctx
                .getBean("helloWorldClient");
        helloWorldClient.run();

    }

    public void run() {
        System.out.println(helloWorldService.getMessage());
    }

    public void setHelloWorldService(HelloWorld helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}