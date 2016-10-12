package com.apress.prospring2.ch02.spring;

import com.apress.prospring2.ch02.decoupled.MessageSource;
import com.apress.prospring2.ch02.decoupled.MessageDestination;

/**
 * @author janm
 */
public class DefaultMessageService implements MessageService {
    private MessageSource source;
    private MessageDestination destination;

    public void execute() {
        this.destination.write(this.source.getMessage());
    }

    public void setSource(MessageSource source) {
        this.source = source;
    }

    public void setDestination(MessageDestination destination) {
        this.destination = destination;
    }
}
