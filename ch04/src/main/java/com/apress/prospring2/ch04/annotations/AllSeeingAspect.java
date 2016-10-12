package com.apress.prospring2.ch04.annotations;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author janm
 */
@Aspect
public class AllSeeingAspect {

    @Around("execution (* com.apress.prospring2.ch04.annotations.*.*(..))")
    public Object seeAll(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp);
        return pjp.proceed();
    }

}
