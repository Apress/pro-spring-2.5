package com.apress.prospring2.ch13.service;

import com.apress.prospring2.ch13.domain.EmailMessage;
import com.apress.prospring2.ch13.domain.MailFormat;

import java.util.Locale;
import java.util.Map;

/**
 * @author anirvanc
 */
public interface EmailMessageProducer {

    EmailMessage produce(final String emailTemplateCode, final Locale locale, MailFormat format, final Map<String, Object> arguments);

}
