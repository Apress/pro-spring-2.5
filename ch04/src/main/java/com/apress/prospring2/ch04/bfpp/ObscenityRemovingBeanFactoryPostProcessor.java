package com.apress.prospring2.ch04.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.util.StringValueResolver;

import java.util.*;

/**
 * @author janm
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor,
        BeanNameAware {
    private Set<String> obscenities;
    private Set<String> obscenitiesRemoved;
    private String name;

    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenities = new HashSet<String>();
        this.obscenitiesRemoved = new HashSet<String>();
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            if (beanName.equals(this.name)) continue;
            
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {
                public String resolveStringValue(String strVal) {
                    if (isObscene(strVal)) {
                        obscenitiesRemoved.add(strVal);
                        return "****";
                    }
                    return strVal;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);
        }
        beanFactory.registerSingleton("obscenitiesRemoved", this.obscenitiesRemoved);
    }

    private boolean isObscene(Object value) {
        String potentialObscenity = value.toString().toUpperCase();
        return this.obscenities.contains(potentialObscenity);
    }

    public void setObscenities(Set<String> obscenities) {
        this.obscenities.clear();
        for (String obscenity : obscenities) {
            this.obscenities.add(obscenity.toUpperCase());
        }
    }

    public void setBeanName(String name) {
        this.name = name;
    }
}
