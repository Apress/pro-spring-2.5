package com.apress.prospring2.ch02.spring;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import com.apress.prospring2.ch02.decoupled.MessageSource;
import com.apress.prospring2.ch02.decoupled.MessageDestination;

/**
 * @author janm
 */
public class FirstSpringHelloWorld {

    public static void main(String[] args) {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(new ClassPathResource("/META-INF/spring/helloworld-context.properties"));

        MessageSource source = (MessageSource) bf.getBean("source");
        MessageDestination destination = (MessageDestination) bf.getBean("destination");

        destination.write(source.getMessage());
    }

}
