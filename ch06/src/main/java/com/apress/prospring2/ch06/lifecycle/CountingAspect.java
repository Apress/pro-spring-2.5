package com.apress.prospring2.ch06.lifecycle;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author janm
 */
@Aspect
public class CountingAspect {
    private int count;

    @Before("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    public void count() {
        this.count++;
        System.out.println(this.count);
    }

}
