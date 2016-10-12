package com.apress.prospring2.ch06.simple;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author janm
 */
@Aspect
public class LoggingAspectPC {
    private String beforeMessage;
    private String afterMessage;

    @Pointcut("execution(* com.apress.prospring2.ch06.simple.TestBean.*(..))")
    private void testBeanExecution() { }

    @Around("testBeanExecution()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(String.format(this.beforeMessage,
                pjp.getSignature().getName(), Arrays.toString(pjp.getArgs())));
        Object ret = pjp.proceed();
        System.out.println(String.format(this.afterMessage,
                pjp.getSignature().getName(), Arrays.toString(pjp.getArgs())));
        return ret;
    }

    @After("testBeanExecution()")
    public void afterCall(JoinPoint jp) {
        System.out.println("After");
    }

    @PostConstruct
    public void initialize() {
        Assert.notNull(this.beforeMessage, "The [beforeMessage] property of [" + getClass().getName() + "] must be set.");
        Assert.notNull(this.afterMessage, "The [afterMessage] property of [" + getClass().getName() + "] must be set.");
    }

    public void setBeforeMessage(String beforeMessage) {
        this.beforeMessage = beforeMessage;
    }

    public void setAfterMessage(String afterMessage) {
        this.afterMessage = afterMessage;
    }
}