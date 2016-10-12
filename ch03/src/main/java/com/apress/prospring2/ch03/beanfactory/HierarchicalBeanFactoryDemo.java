package com.apress.prospring2.ch03.beanfactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class HierarchicalBeanFactoryDemo {

    public static void main(String[] args) {
        XmlBeanFactory parent = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/injectdemo2-context.xml"));
        XmlBeanFactory child = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/injectdemo3-context.xml"), parent);

        System.out.println(parent.getBean("injectSimpleParent"));
        System.out.println(child.getBean("injectSimpleChild"));
        System.out.println(child.getBean("injectSimpleChild2"));
    }

}
