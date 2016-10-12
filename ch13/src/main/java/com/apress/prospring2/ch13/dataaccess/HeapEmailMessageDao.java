package com.apress.prospring2.ch13.dataaccess;

import com.apress.prospring2.ch13.domain.EmailMessage;

import java.util.*;

/**
 * @author janm
 */
public class HeapEmailMessageDao implements EmailMessageDao {
    private long lastId = 0L;
    private Map<Long, EmailMessage> mailQueue = new HashMap<Long, EmailMessage>();

    public void insert(EmailMessage emailMessage) {
        if (emailMessage.getId() == null) {
            this.lastId ++;
            emailMessage.setId(this.lastId);
        }
        this.mailQueue.put(emailMessage.getId(), emailMessage);
    }

    public List<EmailMessage> getUnsent() {
        List<EmailMessage> messages = new ArrayList<EmailMessage>();
        for(Long id : this.mailQueue.keySet()) {
            if(! mailQueue.get(id).isSucceeded()) {
                messages.add(mailQueue.get(id));
            }
        }
        if (!messages.isEmpty()) return messages;
        return null;
    }

    public void delete(EmailMessage emailMessage) {
        this.mailQueue.remove(emailMessage.getId());
    }

    public void update(Long id, int sendAttemptCount, boolean success, Date date) {
        EmailMessage message = this.mailQueue.get(id);
        message.setSentDate(date);
        message.setSendAttemptCount(sendAttemptCount);
        if (success) message.setSucceeded(true);
        this.mailQueue.put(id, message);
    }
}
