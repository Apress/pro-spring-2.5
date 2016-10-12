package com.apress.prospring2.ch06.lifecycle;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author janm
 */
@Aspect("perthis(execution(" +
        "* com.apress.prospring2.ch06.services.UserService.*(..)))")
public class PertargetCountingAspect {
    private int count;

    @Before("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    public void count() {
        this.count++;
        System.out.println(this.count);
    }

}