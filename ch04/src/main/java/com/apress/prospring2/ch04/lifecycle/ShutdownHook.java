package com.apress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.Assert;

/**
 * @author janm
 */
public class ShutdownHook implements Runnable {
    private ConfigurableListableBeanFactory beanFactory;

    public ShutdownHook(ConfigurableListableBeanFactory beanFactory) {
        Assert.notNull(beanFactory, "The 'beanFactory' argument must not be null.");
        this.beanFactory = beanFactory;
    }

    public void run() {
        this.beanFactory.destroySingletons();
    }
}
