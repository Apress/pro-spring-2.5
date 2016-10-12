package com.apress.prospring2.ch04.bpp;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class SimpleBeanDemo2 {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/bpp2-context.xml")
        );
        registerPostProcessor(beanFactory, "bpp");
        registerPostProcessor(beanFactory, "bpp2");
        registerPostProcessor(beanFactory, "bpp3");
        registerPostProcessor(beanFactory, "bpp4");

        SimpleBean sb = (SimpleBean)beanFactory.getBean("simpleBean");
        System.out.println(sb);

        beanFactory.destroySingletons();
    }

    private static void registerPostProcessor(ConfigurableListableBeanFactory beanFactory, String beanName) {
        BeanPostProcessor bpp = (BeanPostProcessor) beanFactory.getBean(beanName);
        beanFactory.addBeanPostProcessor(bpp);
    }

}