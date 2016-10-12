package com.apress.prospring2.ch05.proxies;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author janm
 */
public class TestPointcut extends StaticMethodMatcherPointcut {

    public boolean matches(Method method, Class cls) {
        return ("advised".equals(method.getName()));
    }

}
