package com.apress.prospring2.ch02.decoupled.first;

import com.apress.prospring2.ch02.decoupled.MessageSource;
import com.apress.prospring2.ch02.decoupled.MessageDestination;
import com.apress.prospring2.ch02.decoupled.destination.StdoutMessageDestination;
import com.apress.prospring2.ch02.decoupled.source.SimpleMessageSource;

/**
 * @author janm
 */
public class DecoupledHelloWorld {

    public static void main(String[] args) {
        MessageSource source = new SimpleMessageSource("Hello, world");
        MessageDestination destination = new StdoutMessageDestination();

        destination.write(source.getMessage());
    }

}
