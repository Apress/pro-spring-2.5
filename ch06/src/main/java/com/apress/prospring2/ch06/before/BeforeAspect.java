package com.apress.prospring2.ch06.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import com.apress.prospring2.ch06.common.SecurityContext;

/**
 * @author janm
 */
@Aspect
public class BeforeAspect {

    @Pointcut("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    private void serviceExecution() { }

    @Pointcut("execution(* com.apress.prospring2.ch06.services.DefaultUserService.login(..))")
    private void loginExecution() { }

    @Before("serviceExecution() && !loginExecution()")
    public void beforeLogin() throws Throwable {
        if (SecurityContext.getCurrentUser() == null)
            throw new RuntimeException("Must login to call this method.");
    }


}
