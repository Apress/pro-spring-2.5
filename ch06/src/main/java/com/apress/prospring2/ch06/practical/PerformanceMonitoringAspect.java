package com.apress.prospring2.ch06.practical;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author janm
 */
@Aspect
public class PerformanceMonitoringAspect {
    private PerformanceLogDao performanceLogDao;
    private CallLogDao callLogDao;
    private PerformanceLogExtractor performanceLogExtractor =
            new PerformanceLogExtractor();

    @Pointcut("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    private void serviceCall() { }

    @Before(value = "serviceCall() && target(target)",
            argNames = "jp, target")
    public void logStartCall(JoinPoint jp, Object target) {
    }

    @After(value = "serviceCall() && target(target)",
            argNames = "jp, target")
    public void logEndCall(JoinPoint jp, Object target) {

    }

}
