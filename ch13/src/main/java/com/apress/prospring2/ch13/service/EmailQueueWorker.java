package com.apress.prospring2.ch13.service;

import com.apress.prospring2.ch13.dataaccess.EmailMessageDao;
import com.apress.prospring2.ch13.domain.EmailAddress;
import com.apress.prospring2.ch13.domain.EmailMessage;
import com.apress.prospring2.ch13.domain.EmailMessageAttachment;
import com.apress.prospring2.ch13.domain.EmailAddressType;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.mail.javamail.JavaMailSender;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Message;
import javax.mail.internet.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * @author anirvanc
 */
@ManagedResource(objectName = "com.apress.prospring2.ch13:name=EmailQueueWorker")
public class EmailQueueWorker {

    private EmailMessageDao emailMessageDao;
    private JavaMailSender javaMailSender;

    @ManagedOperation(description = "Runs the queue now")
    public void run() {
        List<EmailMessage> messages = this.emailMessageDao.getUnsent();
        for (EmailMessage message : messages) {
            sendOne(message);
        }
    }

    private void sendOne(EmailMessage message) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        prepareMimeMessage(mimeMessage, message);
        javaMailSender.send(mimeMessage);

        // update the queue
        this.emailMessageDao.update(message.getId(), message.getSendAttemptCount() + 1, true, new Date());
    }

    private void prepareMimeMessage(MimeMessage mimeMessage, EmailMessage emailMessage) {
        try {
            mimeMessage.setFrom(getAddress(emailMessage.getFrom()));
            setRecipients(mimeMessage, emailMessage);
            mimeMessage.setSubject(emailMessage.getSubject());
            if (emailMessage.getReplyTo() != null)
                mimeMessage.setReplyTo(new InternetAddress[]{getAddress(emailMessage.getReplyTo())});
            Multipart multipart = new MimeMultipart("related");

            //plain text
            BodyPart plainTextPart = new MimeBodyPart();
            plainTextPart.setContent(emailMessage.getBody(), "text/plain");
            multipart.addBodyPart(plainTextPart);

            //html part
            BodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(emailMessage.getBody(), "text/html");
            multipart.addBodyPart(htmlPart);

            //attachments
            for (final EmailMessageAttachment attachment : emailMessage.getAttachments()) {
                BodyPart attachmentPart = new MimeBodyPart();
                DataSource dataSource = new DataSource() {
                    public String getContentType() {
                        return attachment.getMimeType();
                    }

                    public InputStream getInputStream() {
                        return new ByteArrayInputStream(attachment.getContent());
                    }

                    public String getName() {
                        return attachment.getFileName();
                    }

                    public OutputStream getOutputStream() {
                        return new ByteArrayOutputStream();
                    }
                };
                attachmentPart.setDataHandler(new DataHandler(dataSource));
                attachmentPart.setFileName(attachment.getFileName());
                multipart.addBodyPart(attachmentPart);
            }
            mimeMessage.setContent(multipart);
        } catch (MessagingException me) {
            // handle the exception
            throw new RuntimeException(me);
        }

    }

    private void setRecipients(MimeMessage mimeMessage, EmailMessage emailMessage) {
        try {
            for (EmailAddress emailAddress : emailMessage.getRecipients()) {
                mimeMessage.addRecipient(resolveType(emailAddress.getAddressType()), getAddress(emailAddress));
            }

        } catch (AddressException ae) {
            // handle exception
            throw new RuntimeException(ae);
        } catch (MessagingException me) {
            // handle exception
            throw new RuntimeException(me);
        }
    }

    private Message.RecipientType resolveType(EmailAddressType addressType) {
        switch (addressType) {
            case To:
                return Message.RecipientType.TO;
            case Cc:
                return Message.RecipientType.CC;
            case Bcc:
                return Message.RecipientType.BCC;
        }
        throw new RuntimeException("Unknown recipient type");
    }

    private InternetAddress getAddress(EmailAddress emailAddress) {
        try {
            return new InternetAddress(emailAddress.getEmailAddress());
        } catch (AddressException ae) {
            // handle exception
            throw new RuntimeException(ae);
        }
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    public void setEmailMessageDao(EmailMessageDao emailMessageDao) {
        this.emailMessageDao = emailMessageDao;
    }
}
