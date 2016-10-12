package com.apress.prospring2.ch18;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class SampleAppHandler extends AbstractFlowHandler {

	@Override
	public String getFlowId() {
		return "main";
	}

	@Override
	public String handleExecutionOutcome(String outcome, AttributeMap output,
			HttpServletRequest request, HttpServletResponse response) {
		return super.handleExecutionOutcome(outcome, output, request, response);
	}
	
}
