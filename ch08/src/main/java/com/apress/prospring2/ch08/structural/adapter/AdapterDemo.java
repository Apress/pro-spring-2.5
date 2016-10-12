package com.apress.prospring2.ch08.structural.adapter;

import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.MessageListener;

/**
 * @author janm
 */
public class AdapterDemo {

    public static void main(String[] args) {
        MessageListener listener = new MessageListenerAdapter();
    }

}
