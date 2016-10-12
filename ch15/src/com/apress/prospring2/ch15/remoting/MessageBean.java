package com.apress.prospring2.ch15.remoting;

import java.io.Serializable;

/**
 * @author aleksav
 */
public class MessageBean implements Serializable {

    private String message;
    private String senderName;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String toString() {
        return "Message: " + message + "\nSender: " + senderName;
    }
}
