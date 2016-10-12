package com.apress.prospring2.ch13.mime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author anirvanc
 */
public class SimpleHtmlMessageSender extends AbstractMessageSender {
    public void sendMessage() throws MessagingException {
        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);

        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setText("<html><head></head><body><h1>Hello World!"
                + "</h1></body></html>", true);

        sender.send(msg);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                new String[] { "/com/apress/prospring2/ch13/mime/simpleHtmlMessageSender.xml",
                        "/com/apress/prospring2/ch13/mime/javaMailSender.xml" });

        SimpleHtmlMessageSender sender = (SimpleHtmlMessageSender) ctx.getBean("messageSender");
        sender.sendMessage();
    }
}
