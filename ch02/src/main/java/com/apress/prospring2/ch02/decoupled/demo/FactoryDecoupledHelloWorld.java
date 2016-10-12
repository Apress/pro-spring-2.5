package com.apress.prospring2.ch02.decoupled.demo;

import com.apress.prospring2.ch02.decoupled.MessageDestination;
import com.apress.prospring2.ch02.decoupled.MessageSource;
import com.apress.prospring2.ch02.decoupled.beanfactory.BeanFactory;

/**
 * @author janm
 */
public class FactoryDecoupledHelloWorld {

    public static void main(String[] args) {
        BeanFactory bf = new BeanFactory("/META-INF/plain/helloworld-context.properties");
        
        MessageSource source = (MessageSource) bf.getBean("source");
        MessageDestination destination = (MessageDestination) bf.getBean("destination");

        destination.write(source.getMessage());
    }
}
