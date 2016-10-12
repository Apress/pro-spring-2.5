package com.apress.prospring2.ch04.interaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author janm
 */
public class ShutdownHookBean implements BeanFactoryAware, Runnable {
    private static final Log logger = LogFactory.getLog(ShutdownHookBean.class);
    private ConfigurableListableBeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof DefaultListableBeanFactory) {
            this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
            Runtime.getRuntime().addShutdownHook(new Thread(this));
        }
    }

    public void run() {
        if (this.beanFactory != null) {
            logger.info("Destroying singletons.");
            this.beanFactory.destroySingletons();
        }
    }
}
