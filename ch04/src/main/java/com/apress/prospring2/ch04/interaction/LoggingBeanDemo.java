/**
 * @author janm
 */
package com.apress.prospring2.ch04.interaction;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class LoggingBeanDemo {
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("/META-INF/spring/interactiondemo-context.xml")
        );
        LoggingBean lb = (LoggingBean)factory.getBean("logging");
        lb.run();
    }
}