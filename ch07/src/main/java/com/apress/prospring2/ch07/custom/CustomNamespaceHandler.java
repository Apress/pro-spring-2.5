package com.apress.prospring2.ch07.custom;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.w3c.dom.Element;

/**
 * @author anirvanc
 */
public class CustomNamespaceHandler extends NamespaceHandlerSupport {

	private static class GreeterBeanDefinitionParser extends
			AbstractSingleBeanDefinitionParser {

		@Override
		protected Class getBeanClass(Element element) {
			return GreeterFactoryBean.class;
		}

		@Override
		protected void doParse(Element element, ParserContext parserContext,
							   BeanDefinitionBuilder builder) {
			builder.addPropertyValue("message", element.getAttribute("message"));
			String countString = element.getAttribute("count");
			try {
				int count = Integer.parseInt(countString);
				builder.addPropertyValue("count", count);
			} catch (NumberFormatException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public void init() {
		registerBeanDefinitionParser("greeter", new GreeterBeanDefinitionParser());
	}

}
