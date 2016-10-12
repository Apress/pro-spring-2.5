package com.apress.prospring2.ch08.creational.prototype;

/**
 * @author janm
 */
public class SpringPrototypeClient {
    private Message message1;
    private Message message2;

    public void run() {
        System.out.println("Message1 " + this.message1.toString());
        System.out.println("Message2 " + this.message2.toString());
        System.out.println("Messages == " + (this.message1 == this.message2));
    }

    public void setMessage1(Message message1) {
        this.message1 = message1;
    }

    public void setMessage2(Message message2) {
        this.message2 = message2;
    }
}
