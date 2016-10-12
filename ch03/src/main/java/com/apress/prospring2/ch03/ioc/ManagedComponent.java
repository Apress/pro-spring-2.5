package com.apress.prospring2.ch03.ioc;

import org.springframework.beans.factory.BeanFactory;

/**
 * @author janm
 */
public interface ManagedComponent {

    void lookup(BeanFactory container);

}
