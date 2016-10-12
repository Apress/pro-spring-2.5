package com.apress.prospring2.ch03.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author janm
 */
public class ConstructorConfusionDemo {
    private String someValue;

    public ConstructorConfusionDemo(String someValue) {
        System.out.println("ConstructorConfusionDemo(String) called");
        this.someValue = someValue;
    }

    public ConstructorConfusionDemo(int someValue) {
        System.out.println("ConstructorConfusionDemo(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/beanfactorydemo3-context.xml"));

        ConstructorConfusionDemo cc = (ConstructorConfusionDemo)factory.getBean("constructorConfusion");
        System.out.println(cc);
    }

    public String toString() {
        return someValue;
    }

}
