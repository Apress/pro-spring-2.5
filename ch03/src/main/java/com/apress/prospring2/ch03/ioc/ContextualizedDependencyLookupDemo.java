package com.apress.prospring2.ch03.ioc;

import com.apress.prospring2.ch02.spring.MessageService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.Set;
import java.util.HashSet;

/**
 * @author janm
 */
public class ContextualizedDependencyLookupDemo {
    private static Set<ManagedComponent> components = new HashSet<ManagedComponent>();

    private static class MessageServiceComponent implements ManagedComponent {
        private MessageService service;

        public void lookup(BeanFactory container) {
            this.service = (MessageService)container.getBean("service");
        }

        public void run() {
            this.service.execute();
        }
    }

    public static void main(String[] args) {
        BeanFactory bf = getBeanFactory();
        MessageServiceComponent msc = new MessageServiceComponent();
        registerComponent(msc);
        allowComponentsToLookup(bf);
        msc.run();
    }

    private static void allowComponentsToLookup(BeanFactory bf) {
        for (ManagedComponent component : components) {
            component.lookup(bf);
        }
    }

    private static void registerComponent(ManagedComponent managedComponent) {
        components.add(managedComponent);
    }

    private static BeanFactory getBeanFactory() {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(new ClassPathResource("/META-INF/spring/ioc-pull-context.properties"));
        return bf;
    }

}
