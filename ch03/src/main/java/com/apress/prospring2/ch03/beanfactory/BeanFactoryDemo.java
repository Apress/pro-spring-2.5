package com.apress.prospring2.ch03.beanfactory;

import com.apress.prospring2.ch03.di.Oracle;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class BeanFactoryDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(new ClassPathResource("/META-INF/spring/beanfactorydemo1-context.properties"));

        Oracle oracle = (Oracle) bf.getBean("oracle");
        System.out.println("Meaning of life is " + oracle.defineMeaningOfLife());
    }

}
