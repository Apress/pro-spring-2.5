package com.apress.prospring2.ch04.bfpp;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class PropertyConfigurerDemo {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/bfpp2-context.xml")
        );
        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor)beanFactory.getBean("bfpp");
        bfpp.postProcessBeanFactory(beanFactory);

        System.out.println(beanFactory.getBean("simpleBean"));
    }

}
