package com.apress.prospring2.ch13.simple;

import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author anirvanc
 */
public class JavaMailSimpleMailSender extends SimpleMailSender{
    protected MailSender getMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("post.demon.co.uk");
        return sender;
    }
}
