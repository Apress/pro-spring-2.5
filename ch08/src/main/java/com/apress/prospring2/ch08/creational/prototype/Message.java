package com.apress.prospring2.ch08.creational.prototype;

/**
 * @author janm
 */
public abstract class Message {

    public Message makeCopy() {
        try {
            return this.getClass().newInstance();
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }
}
