package com.apress.prospring2.ch06.proxies;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;

/**
 * @author janm
 */
@Aspect
public class BeforeAspect {

    @Before("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    public void simpleLog(JoinPoint jp) {
        System.out.println("Before " + jp);
    }

}
