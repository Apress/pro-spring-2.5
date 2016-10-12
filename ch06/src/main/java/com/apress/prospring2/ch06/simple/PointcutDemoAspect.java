package com.apress.prospring2.ch06.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;

/**
 * @author janm
 */
@Aspect
public class PointcutDemoAspect {

    @Around("SystemPointcuts.testBeanExecution()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

    //@Around("args(String, ..)")
    // @Around("execution(* SimpleBean.*(CharSequence, String))")
    @Around("bean(simple)")
    public Object inTestBean(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("X: " + pjp);
        return pjp.proceed();
    }

}