package com.apress.prospring2.ch18;

import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class ColoursHandler extends AbstractFlowHandler {

	@Override
	public String getFlowId() {
		return "events";
	}

}
