package com.apress.prospring2.ch02.decoupled.destination;

import com.apress.prospring2.ch02.decoupled.MessageDestination;

/**
 * @author janm
 */
public class StdoutMessageDestination implements MessageDestination {
    
    public void write(String message) {
        System.out.println(message);
    }
}
