package com.apress.prospring2.ch13.service;

import com.apress.prospring2.ch13.domain.EmailMessage;

/**
 * @author janm
 */
public interface EmailService {

    void enqueue(final EmailMessage message);
    
}
