package com.apress.prospring2.ch02.decoupled;

/**
 * @author janm
 */
public interface MessageDestination {

    void write(String message);
    
}
