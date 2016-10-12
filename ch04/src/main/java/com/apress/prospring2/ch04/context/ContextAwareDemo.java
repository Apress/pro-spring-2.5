package com.apress.prospring2.ch04.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class ContextAwareDemo implements ApplicationContextAware {
    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        ctx = applicationContext;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "/META-INF/spring/acdemo1-context.xml");

        ContextAwareDemo demo = (ContextAwareDemo) ctx.getBean("contextAware");
        demo.displayAppContext();
    }

    public void displayAppContext() {
        System.out.println(ctx);
    }

}
