package com.apress.prospring2.ch03.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class AliasDemo {
    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(
                             new ClassPathResource("/META-INF/spring/aliasdemo-context.xml"));

        String s1 = (String)factory.getBean("name1");
        String s2 = (String)factory.getBean("name2");
        String s3 = (String)factory.getBean("name3");
        String s4 = (String)factory.getBean("name4");
        String s5 = (String)factory.getBean("namex1");
        String s6 = (String)factory.getBean("namex2");

        System.out.println((s1 == s2));
        System.out.println((s2 == s3));
        System.out.println((s3 == s4));
        System.out.println((s4 == s5));
        System.out.println((s5 == s6));
    }

}
