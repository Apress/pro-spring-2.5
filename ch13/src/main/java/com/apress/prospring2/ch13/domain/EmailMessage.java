package com.apress.prospring2.ch13.domain;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author anirvanc
 */
public class EmailMessage extends AbstractIdentityObject<Long> implements Serializable {
	private Set<EmailAddress> recipients = new HashSet<EmailAddress>();
	private Set<EmailMessageAttachment> attachments = new HashSet<EmailMessageAttachment>();
	private EmailAddress from;
	private EmailAddress replyTo;
	private String subject;
	private String body;
	private boolean succeeded;
	private int sendAttemptCount;
	private Date sendDate;
	private Date sentDate;

	/**
	 * Adds the recipient
	 * @param address The recipient
	 */
	public void addRecipient(EmailAddress address) {
//		address.setEmailMessage(this);
		this.recipients.add(address);
	}

	/**
	 * Adds an attachment
	 * @param attachment The attachment
	 */
	public void addAttachment(EmailMessageAttachment attachment) {
//		attachment.setEmailMessage(this);
		this.attachments.add(attachment);
	}

	/**
	 * Checks that the message is valid
	 */
	public void validate() {
		if (!StringUtils.hasText(this.subject)) throw new IllegalArgumentException("Subject is missing.");
		if (!StringUtils.hasText(this.body)) throw new IllegalArgumentException("Body is missing.");

		this.from.validate();
		if (this.replyTo != null) {
			this.replyTo.validate();
		}
		for (EmailAddress recipient : this.recipients) {
			recipient.validate();
		}
		/*for (EmailMessageAttachment attachment : this.attachments) {
			attachment.validate();
		}*/
	}

	public Set<EmailAddress> getRecipients() {
		return recipients;
	}

	public void setRecipients(final Set<EmailAddress> recipients) {
		this.recipients = recipients;
	}

	public Set<EmailMessageAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(final Set<EmailMessageAttachment> attachments) {
		this.attachments = attachments;
	}

	public EmailAddress getFrom() {
		return from;
	}

	public void setFrom(final EmailAddress from) {
		this.from = from;
	}

	public EmailAddress getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(final EmailAddress replyTo) {
		this.replyTo = replyTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(final boolean succeeded) {
		this.succeeded = succeeded;
	}

	public int getSendAttemptCount() {
		return sendAttemptCount;
	}

	public void setSendAttemptCount(final int sendAttemptCount) {
		this.sendAttemptCount = sendAttemptCount;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(final Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(final Date sentDate) {
		this.sentDate = sentDate;
	}

}
