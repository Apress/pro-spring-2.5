package com.apress.prospring2.ch13.domain;

/**
 * @author janm
 */
public enum EmailAddressType {
	To(1),
	Cc(2),
	Bcc(3);

	private int id;

	EmailAddressType(final int id) {
		this.id = id;
	}

	/**
	 * Gets the id value
	 * @return The value
	 */
	public int toInt() {
		return this.id;
	}

	/**
	 * Translates the int value to an EmailAddressType
	 * @param value The value
	 * @return The EmailAddressType
	 */
	public static EmailAddressType fromInt(final int value) {
		for (EmailAddressType type : EmailAddressType.values()) {
			if (type.id == value) return type;
		}

		throw new IllegalArgumentException("Value " + value + " is not a valid EmailAddressType.");
	}
}
