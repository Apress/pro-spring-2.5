package com.apress.prospring2.ch04.bfpp;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

/**
 * @author janm
 */
public class ObscenityCleaningDemo {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/bfpp-context.xml")
        );
        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor)beanFactory.getBean("bfpp");
        bfpp.postProcessBeanFactory(beanFactory);

        SimpleBean simpleBean = (SimpleBean) beanFactory.getBean("simpleBean");
        System.out.println(simpleBean);
        System.out.println(beanFactory.getBean("obscenitiesRemoved"));
    }

}
