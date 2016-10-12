package com.apress.prospring2.ch18.sample;

import java.io.Serializable;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.util.StringUtils;

public class Address implements Serializable {

	private static final long serialVersionUID = 100L;

	private String address1;
	private String address2;
	private String postcode;
	private String town;
	
	public Address() {
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	/*
	public void validateStart(MessageContext context) {
		if(!StringUtils.hasLength(postcode)) {
			context.addMessage(new MessageBuilder().error().source("postcode")
					.defaultText("Enter Postcode").build());
		}
	}*/
}
