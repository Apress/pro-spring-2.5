package com.apress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class SimpleBeanDemo {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/lifecycledemo3-context.xml"));
        System.out.println(factory.getBean("simple1"));
    }

}
