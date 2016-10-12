package com.apress.prospring2.ch13.service;

import com.apress.prospring2.ch13.domain.EmailAddress;
import com.apress.prospring2.ch13.domain.EmailAddressType;
import com.apress.prospring2.ch13.domain.EmailMessage;
import com.apress.prospring2.ch13.dataaccess.EmailMessageDao;
import com.apress.prospring2.ch13.dataaccess.HeapEmailMessageDao;
import com.apress.prospring2.mock.AbstractSpringIntegrationTest;

import java.util.HashSet;
import java.util.Set;

import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.springframework.test.AbstractSingleSpringContextTests;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import junit.framework.TestCase;

/**
 * @author anirvanc
 */
//public class DefaultEmailServiceTest extends AbstractSpringIntegrationTest {
public class DefaultEmailServiceTest extends AbstractDependencyInjectionSpringContextTests {
    private EmailService emailService;
    private EmailMessageDao emailMessageDao;

    protected String[] getConfigLocations() {
        return new String[] {                
                "com/apress/prospring2/ch13/dataaccess/dataaccess-context.xml",
                "com/apress/prospring2/ch13/service/email-context.xml"
        };
    }

    private EmailMessage createEmailMessage() {
        Set<EmailAddress> recipients = new HashSet<EmailAddress>();
        recipients.add(new EmailAddress(EmailAddressType.To, "anirvanc@cakesolutions.net"));
        EmailMessage message = new EmailMessage();
        message.setFrom(new EmailAddress(EmailAddressType.To, "admin@prospring2.com"));
        message.setSubject("Test email");
        message.setBody("This is a test email.");
        message.setRecipients(recipients);
        return message;
    }

    public void testVoid() {
        EmailMessage message = createEmailMessage();
        message.setSubject(null);
        assertNull("Should not have enqueued", message.getId());
        message.setSubject("Test mail");
        EmailMessage anotherMessage = createEmailMessage();
        this.emailService.enqueue(message);
        assertNotNull("Should have enqueued", message.getId());
        this.emailService.enqueue(anotherMessage);
        assertNotNull("Should have enqueued", anotherMessage.getId());
        assertEquals("Failed", 2, this.emailMessageDao.getUnsent().size());
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void setEmailMessageDao(EmailMessageDao emailMessageDao) {
        this.emailMessageDao = emailMessageDao;
    }
}
