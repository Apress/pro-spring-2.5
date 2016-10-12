package com.apress.prospring2.ch13.mime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author anirvanc
 */
public class ComplexMessageSender extends AbstractMessageSender {
    public void sendMessage() throws MessagingException {
        sender.send(new MessagePreparator());
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                new String[] {
                        "/com/apress/prospring2/ch13/mime/complexMessageSender.xml",
                        "/com/apress/prospring2/ch13/mime/javaMailSender.xml" });

        ComplexMessageSender sender = (ComplexMessageSender) ctx.getBean("messageSender");
        sender.sendMessage();
    }

    private class MessagePreparator implements MimeMessagePreparator {

        public void prepare(MimeMessage msg) throws Exception {

            // set header details
            msg.addFrom(InternetAddress.parse(from));
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);

            // create wrapper multipart/alternative part
            MimeMultipart ma = new MimeMultipart("alternative");
            msg.setContent(ma);

            // create the plain text
            BodyPart plainText = new MimeBodyPart();
            plainText.setText("This is the plain text version of the mail.");
            ma.addBodyPart(plainText);

            //  create the html and image multipart wrapper
            BodyPart related = new MimeBodyPart();
            MimeMultipart mr = new MimeMultipart("related");
            related.setContent(mr);
            ma.addBodyPart(related);

            BodyPart html = new MimeBodyPart();
            html.setContent(
                    "<html><head></head><body><h1>This is the HTML version of the mail."
                            + "</h1><img src=\"cid:0001\"></body></html>", "text/html");
            mr.addBodyPart(html);

            BodyPart img = new MimeBodyPart();
            img.setHeader("Content-ID", "0001");
            img.setDisposition("inline");
            img.setDataHandler(new DataHandler(
                    new FileDataSource("./ch13/src/main/resources/images/apress.gif")));
            mr.addBodyPart(img);
        }
    }
}
