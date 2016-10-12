package com.apress.prospring2.ch05.annotation;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by aleksav
 */
public class AnnotationAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.print("After annotated method: " + method);
    }
}