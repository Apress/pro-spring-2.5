package com.apress.prospring2.ch08.creational.prototype;

/**
 * @author janm
 */
public class PrototypeDemo {

    private Message message;

    PrototypeDemo(Message message) {
        this.message = message;
    }

    Message makeMessage() {
        return this.message.makeCopy(); 
    }

    public static void main(String[] args) {
        Message prototype = new EmailMessage();
        PrototypeDemo demo = new PrototypeDemo(prototype);
        System.out.println("Message "  + demo.makeMessage());
    }
}
