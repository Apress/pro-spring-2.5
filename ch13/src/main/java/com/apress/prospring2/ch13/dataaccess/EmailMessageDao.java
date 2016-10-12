package com.apress.prospring2.ch13.dataaccess;

import com.apress.prospring2.ch13.domain.EmailMessage;

import java.util.List;
import java.util.Date;

/**
 * @author janm
 */
public interface EmailMessageDao {

    void insert(EmailMessage emailMessage);

    List<EmailMessage> getUnsent();

    void delete(EmailMessage emailMessage);

    void update(Long id, int sendAttemptCount, boolean success, Date date);
}
