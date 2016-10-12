package com.apress.prospring2.ch06.xml;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author janm
 */
public final class Pointcuts {
    private Pointcuts() {

    }

    @Pointcut("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    public void serviceExecution() { }

}
