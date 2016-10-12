package com.apress.prospring2.ch04.bfpp;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

/**
 * @author janm
 */
public class PostProcessorDemo {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/bfpp-context.xml")
        );
        BeanPostProcessor bpp = (BeanPostProcessor)beanFactory.getBean("bpp");
        beanFactory.addBeanPostProcessor(bpp);
        for (Map.Entry<?, ?> e : ((Map<?, ?>)beanFactory.getBeansOfType(BeanFactoryPostProcessor.class)).entrySet()) {
            BeanFactoryPostProcessor postProcessor = (BeanFactoryPostProcessor) e.getValue();
            postProcessor.postProcessBeanFactory(beanFactory);
        }

        System.out.println(beanFactory.getBean("complexBean"));
    }

}