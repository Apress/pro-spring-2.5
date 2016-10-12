package com.apress.prospring2.ch05.aspectj;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by aleksav
 */
public class SimpleAfterAdvice implements AfterReturningAdvice{
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After method: " + method);
    }
}
