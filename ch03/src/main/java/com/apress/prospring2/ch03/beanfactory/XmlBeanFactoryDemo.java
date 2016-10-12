package com.apress.prospring2.ch03.beanfactory;

import com.apress.prospring2.ch03.di.Oracle;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class XmlBeanFactoryDemo {

    public static void main(String[] args) {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/beanfactorydemo2-context.xml"));

        Oracle oracle = (Oracle) bf.getBean("oracle");
        System.out.println("Meaning of life is " + oracle.defineMeaningOfLife());
    }

}