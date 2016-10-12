package com.apress.prospring2.ch04.mi;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author janm
 */
public class FormatMessageReplacer implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String msg = (String) args[0];
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>").append(msg).append("</h2>");
        return sb.toString();
    }
}
