package com.apress.prospring2.ch20.interfacebased;

/**
 * @author anirvanc
 */
public interface ManagedInterface {

    void setProperty(String property);
    String getProperty();
    String exposedMethod();
    String anotherExposedMethod();
    
}
