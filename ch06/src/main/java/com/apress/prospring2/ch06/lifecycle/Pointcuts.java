package com.apress.prospring2.ch06.lifecycle;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author janm
 */
public final class Pointcuts {
    private Pointcuts() {

    }

    @Pointcut("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    public void serviceCall() { }
}
