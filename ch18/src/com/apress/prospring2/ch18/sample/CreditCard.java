package com.apress.prospring2.ch18.sample;

import java.io.Serializable;

public class CreditCard implements Serializable {

	private static final long serialVersionUID = 150L;

	private String cardNumber;
	private String cardHolder;
	private String cardExpiry;
	
	public CreditCard() {
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	
}
