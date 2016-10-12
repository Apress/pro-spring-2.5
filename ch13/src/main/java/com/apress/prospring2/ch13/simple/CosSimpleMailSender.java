package com.apress.prospring2.ch13.simple;

import org.springframework.mail.MailSender;

/**
 * @author anirvanc
 */
public class CosSimpleMailSender extends SimpleMailSender{
    protected MailSender getMailSender() {
//        CosMailSenderImpl sender = new CosMailSenderImpl();
//        sender.setHost("post.demon.co.uk");
//        return sender;
        return null;
    }
}
