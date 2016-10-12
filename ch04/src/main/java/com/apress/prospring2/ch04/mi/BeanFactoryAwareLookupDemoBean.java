package com.apress.prospring2.ch04.mi;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.BeansException;

/**
 * @author janm
 */
public class BeanFactoryAwareLookupDemoBean implements DemoBean, BeanFactoryAware {
    private BeanFactory beanFactory;

    public MyHelper getMyHelper() {
        return (MyHelper) this.beanFactory.getBean("helper");
    }

    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
