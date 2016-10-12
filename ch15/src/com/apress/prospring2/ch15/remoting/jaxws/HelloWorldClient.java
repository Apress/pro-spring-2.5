package com.apress.prospring2.ch15.remoting.jaxws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.apress.prospring2.ch15.remoting.rmi.RemoteHelloWorld;


/**
 * @author aleksav
 */
public class HelloWorldClient {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/jaxws/client.xml");

        RemoteHelloWorld helloWorld = (RemoteHelloWorld) ctx.getBean("helloWorldService");
//        Service serviceModel = new ObjectServiceFactory().create(HelloWorld.class, "HelloWorld", "http://localhost:8080/remoting/ws", null);
//        HelloWorld helloWorld = (HelloWorld)
//                new XFireProxyFactory().create(serviceModel, "http://localhost:8080/remoting/ws/HelloWorld");

//        new JaxWsPortProxyFactoryBean();
        System.out.println(helloWorld.getMessage());
    }
}
