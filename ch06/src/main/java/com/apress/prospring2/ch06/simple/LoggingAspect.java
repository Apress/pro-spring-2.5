package com.apress.prospring2.ch06.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author janm
 */
@Aspect
public class LoggingAspect {

    @Around("execution(* com.apress.prospring2.ch06.simple.TestBean.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before");
        Object ret = pjp.proceed();
        System.out.println("After");
        return ret;
    }

}
