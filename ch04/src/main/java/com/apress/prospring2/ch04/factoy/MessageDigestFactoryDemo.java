package com.apress.prospring2.ch04.factoy;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.security.MessageDigest;

/**
 * @author janm
 */
public class MessageDigestFactoryDemo {

    public static void main(String[] args) throws Exception {
        XmlBeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/factorydemo-context.xml")
        );
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean)factory.getBean("&sha");
        MessageDigest d1 = (MessageDigest)factory.getBean("sha");
        MessageDigest d2 = (MessageDigest)factoryBean.getObject();
        System.out.println("Equal MessageDigests created? "
                + (d1.getAlgorithm().equals(d2.getAlgorithm())));
    }

}