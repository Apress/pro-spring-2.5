package com.apress.prospring2.ch04.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class EventPublisherDemo implements ApplicationContextAware {

    private ApplicationContext ctx;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "/META-INF/spring/eventsdemo1-context.xml");

        EventPublisherDemo pub = (EventPublisherDemo) ctx.getBean("publisher");
        pub.publish("Hello World!");
        pub.publish("The quick brown fox jumped over the lazy dog");
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.ctx = applicationContext;

    }

    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }

}
