package com.apress.prospring2.ch20.remote.server;

/**
 * @author ProSpring
 */
public interface ManagedInterface {

    void setProperty(String property);

    String getProperty();

    String exposedMethod();
    
    String anotherExposedMethod();
}
