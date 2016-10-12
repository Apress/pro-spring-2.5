package com.apress.prospring2.ch18.sample.service;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.apress.prospring2.ch18.sample.Address;

@Component
public class AddressValidator {

	public void validateStart(Address address, MessageContext context) {
		if(!StringUtils.hasLength(address.getPostcode())) {
			context.addMessage(new MessageBuilder().error().source("postcode")
					.defaultText("Enter Postcode").build());
		}
	}
}
