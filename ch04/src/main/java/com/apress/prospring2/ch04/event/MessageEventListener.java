package com.apress.prospring2.ch04.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationEvent;

/**
 * @author janm
 */
public class MessageEventListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent)event;
            System.out.println("Received " + messageEvent.getMessage() +
                    " from " + messageEvent.getSource());
        }
    }
}
