package com.apress.prospring2.ch13.service;

import com.apress.prospring2.ch13.domain.EmailMessage;
import com.apress.prospring2.ch13.dataaccess.EmailMessageDao;

/**
 * @author anirvanc
 */
public class DefaultEmailService implements EmailService {
    private EmailMessageDao emailMessageDao;

    public void enqueue(final EmailMessage message) {
        try {
            message.validate();
        } catch (IllegalArgumentException e) {
            // Invalid message, handle it
            return;
        }

        // the message is valid; insert it to the queue
        this.emailMessageDao.insert(message);
    }

    public void setEmailMessageDao(final EmailMessageDao emailMessageDao) {
        this.emailMessageDao = emailMessageDao;
    }
}
