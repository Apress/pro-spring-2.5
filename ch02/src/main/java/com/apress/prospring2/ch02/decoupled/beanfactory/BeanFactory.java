package com.apress.prospring2.ch02.decoupled.beanfactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author janm
 */
public class BeanFactory {
    private Map<String, String> beanDefinitions;

    public BeanFactory(String beanDefinitionsSource) {
        readBeanDefinitions(beanDefinitionsSource);
    }

    private void readBeanDefinitions(String beanDefinitionsSource) {
        Properties props = new Properties();
        InputStream is = BeanFactory.class.getResourceAsStream(beanDefinitionsSource);
        if (is == null) throw new IllegalArgumentException("Could not load properties file " + beanDefinitionsSource);
        try {
            props.load(is);
            is.close();
            this.beanDefinitions = new HashMap<String, String>();
            for (Map.Entry<Object, Object> entry : props.entrySet()) {
                this.beanDefinitions.put(entry.getKey().toString(), entry.getValue().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read the properties file " + beanDefinitionsSource);
        }
    }

    public Object getBean(String name) {
        String className = this.beanDefinitions.get(name);
        if (className == null) return null;
        try {
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not create bean " + name);
        }
    }

}
