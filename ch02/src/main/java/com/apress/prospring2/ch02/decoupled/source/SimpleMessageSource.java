package com.apress.prospring2.ch02.decoupled.source;

import com.apress.prospring2.ch02.decoupled.MessageSource;

/**
 * @author janm
 */
public class SimpleMessageSource implements MessageSource {
    private final String message;

    public SimpleMessageSource() {
        this("Hello, world");
    }

    public SimpleMessageSource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
