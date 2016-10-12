package com.apress.prospring2.ch13.mime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author anirvanc
 */
public class AlternativeFormatMessageSender extends AbstractMessageSender {
    public void sendMessage() {
        sender.send(new MessagePreparator());
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                new String[] {
                        "/com/apress/prospring2/ch13/mime/alternativeFormatMessageSender.xml",
                        "/com/apress/prospring2/ch13/mime/javaMailSender.xml" });

        AlternativeFormatMessageSender sender = (AlternativeFormatMessageSender) ctx.getBean("messageSender");
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

            //  create the html part
            BodyPart html = new MimeBodyPart();
            html.setContent(
                    "<html><head></head><body><h1>This is the HTML version of the mail."
                            + "</h1></body></html>", "text/html");
            ma.addBodyPart(html);
        }
    }
}
