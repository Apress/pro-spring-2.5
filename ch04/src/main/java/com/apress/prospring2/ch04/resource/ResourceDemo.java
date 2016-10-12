package com.apress.prospring2.ch04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author janm
 */
public class ResourceDemo {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "/META-INF/spring/resourcesdemo1-context.xml");

        Resource res1 = ctx.getResource("file:///tmp");
        displayInfo(res1);
        Resource res2 = ctx.getResource("classpath:com/apress/prospring2/ch04/pe/Complex.class");
        displayInfo(res2);
        Resource res3 = ctx.getResource("http://www.google.co.uk");
        displayInfo(res3);
    }

    private static void displayInfo(Resource res) throws Exception{
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }

}
