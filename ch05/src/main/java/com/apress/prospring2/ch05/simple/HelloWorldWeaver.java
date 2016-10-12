package com.apress.prospring2.ch05.simple;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author janm
 */
public class HelloWorldWeaver {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        // create the proxy
        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();

        // write the messages
        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();
    }

}
