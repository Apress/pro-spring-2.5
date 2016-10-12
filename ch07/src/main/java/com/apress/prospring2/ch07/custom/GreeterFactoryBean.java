package com.apress.prospring2.ch07.custom;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author anirvanc
 */
public class GreeterFactoryBean extends AbstractFactoryBean {

    private String message;
    private int count;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
	protected Object createInstance() {
        if (this.message == null) {
            throw new IllegalArgumentException("'message' is required");
        }
        return new StdoutGreeter(this.count, this.message);
    }

    @Override
	public Class getObjectType() {
        return Greeter.class;
    }

}
