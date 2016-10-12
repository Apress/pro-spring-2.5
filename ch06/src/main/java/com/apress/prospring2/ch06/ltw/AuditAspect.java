package com.apress.prospring2.ch06.ltw;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author janm
 */
@Aspect
public class AuditAspect {

    @After(value =
              "execution(* com.apress.prospring2.ch06.services.*.*(..)) && " +
              "this(t)",
           argNames = "jp,t")
    public void audit(JoinPoint jp, Object t) {
        System.out.println("After call to " + t + " (" + jp + ")");
    }

}
