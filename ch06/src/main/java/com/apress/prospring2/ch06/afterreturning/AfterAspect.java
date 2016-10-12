package com.apress.prospring2.ch06.afterreturning;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import com.apress.prospring2.ch06.common.User;

/**
 * @author janm
 */
@Aspect
public class AfterAspect {

    @AfterReturning(pointcut = "execution(* com.apress.prospring2.ch06.services.*.*(..))",
        returning = "ret", argNames = "ret")
    public void auditCall(Object ret) {
        System.out.println("After method call of " + ret);
        if (ret instanceof User) {
            ((User)ret).setPassword("****");
        }
    }

}
