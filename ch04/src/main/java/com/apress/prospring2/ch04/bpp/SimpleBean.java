package com.apress.prospring2.ch04.bpp;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * @author janm
 */
public class SimpleBean {
    @Timestamp
    Date creationDate;
    
    @Autowired
    String dependency;

    @PostConstruct
    public void initialize() {
        System.out.println("Initializing bean " + getClass());
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Cleaning up bean " + getClass());
    }

    @Override
    public String toString() {
        return "Bean was created at " + this.creationDate + " with " + this.dependency;
    }
}
