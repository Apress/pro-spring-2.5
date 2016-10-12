package com.apress.prospring2.ch13.mime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author anirvanc
 */
public class AttachmentMessageSender extends AbstractMessageSender {
    public void sendMessage() throws MessagingException {
        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);

        helper.setText(
                "<html><head></head><body><h1>Hello World!</h1></body></html>",
                true);

        // add the image
        FileSystemResource img = new FileSystemResource(new File("./ch13/src/main/resources/images/apress.gif"));
        helper.addAttachment("apress.gif", img);

        sender.send(msg);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                new String[] { "/com/apress/prospring2/ch13/mime/attachmentMessageSender.xml",
                        "/com/apress/prospring2/ch13/mime/javaMailSender.xml" });

        AttachmentMessageSender sender = (AttachmentMessageSender) ctx.getBean("messageSender");
        sender.sendMessage();
    }

}
