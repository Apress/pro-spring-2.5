package com.apress.prospring2.ch06.afterthrowing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author janm
 */
@Aspect
public class AfterThowingAspect {

    @AfterThrowing(pointcut = "execution(* com.apress.prospring2.ch06.services.*.*(..))",
        throwing = "ex", argNames = "ex")
    public void logException(Exception ex) {
        System.out.println("After method call of " + ex);
    }

}
