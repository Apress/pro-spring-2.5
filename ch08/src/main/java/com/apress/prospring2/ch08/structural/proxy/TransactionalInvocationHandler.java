package com.apress.prospring2.ch08.structural.proxy;

import org.springframework.util.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author janm
 */
public class TransactionalInvocationHandler implements InvocationHandler {
    private SimpleDao target;

    public TransactionalInvocationHandler(SimpleDao target) {
        Assert.notNull(target, "The target argument cannot be null");
        this.target = target;
    }

    private void begin() {
        System.out.println("* begin");
    }

    private void commit() {
        System.out.println("* commit");
    }

    private void rollback() {
        System.out.println("* rollback");
    }

    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
        begin();
        try {
            Object result = method.invoke(this.target, arguments);
            commit();
            return result;
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }
}
