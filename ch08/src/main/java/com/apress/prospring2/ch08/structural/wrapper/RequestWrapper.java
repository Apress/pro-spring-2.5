package com.apress.prospring2.ch08.structural.wrapper;

/**
 * @author janm
 */
public class RequestWrapper implements Request {
    private Request request;

    public RequestWrapper(final Request request) {
        this.request = request;
    }

    public String getAction() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object getArgument(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
