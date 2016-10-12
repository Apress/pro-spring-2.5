package com.apress.prospring2.ch13.domain;

import org.springframework.util.StringUtils;

/**
 * @author janm
 */
public class EmailAddress {
	private String emailAddress;
	private String fullName;
	private EmailAddressType addressType;

	public EmailAddress() {

	}

	public EmailAddress(final EmailAddressType addressType, final String emailAddress) {
		this.addressType = addressType;
		this.emailAddress = emailAddress;
	}

	public EmailAddress(final EmailAddressType addressType, final String emailAddress, final String fullName) {
		this.addressType = addressType;
		this.emailAddress = emailAddress;
		this.fullName = fullName;
	}

	public EmailAddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(final EmailAddressType addressType) {
		this.addressType = addressType;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Checks that this instance is valid
	 */
	public void validate() {
		if (!StringUtils.hasText(this.emailAddress)) throw new IllegalArgumentException("Email address is missing.");
	}
}
