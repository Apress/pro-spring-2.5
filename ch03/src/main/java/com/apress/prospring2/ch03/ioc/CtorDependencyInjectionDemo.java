package com.apress.prospring2.ch03.ioc;

import com.apress.prospring2.ch02.spring.MessageService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

/**
 * @author janm
 */
public class CtorDependencyInjectionDemo {

    private static class DependantComponent {
        private MessageService service;

        private DependantComponent(MessageService service) {
            Assert.notNull(service, "The 'service' argument must not be null.");
            this.service = service;
        }

        public void run() {
            this.service.execute();
        }
    }


    public static void main(String[] args) {
        BeanFactory bf = getBeanFactory();

        MessageService service = (MessageService) bf.getBean("service");

        DependantComponent dc = new DependantComponent(service);
        dc.run();
    }

    private static BeanFactory getBeanFactory() {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(new ClassPathResource("/META-INF/spring/ioc-pull-context.properties"));
        return bf;
    }

}
