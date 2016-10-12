package com.apress.prospring2.ch13.simple;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailException;

/**
 * @author anirvanc
 */
public abstract class SimpleMailSender {
    protected abstract MailSender getMailSender();

    public void sendMessage(String to, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("Test Message");
        msg.setFrom("test@apress.com");
        msg.setText(text);

        MailSender sender = getMailSender();
        try {
            sender.send(msg);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
