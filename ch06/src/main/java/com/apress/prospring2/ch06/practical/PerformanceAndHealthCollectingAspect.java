package com.apress.prospring2.ch06.practical;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * @author janm
 */
@Aspect
public class PerformanceAndHealthCollectingAspect {

    private PerformanceLogDao performanceLogDao;
    private ExceptionLogDao exceptionLogDao;
    private PerformanceLogExtractor performanceLogExtractor =
            new PerformanceLogExtractor();
    private ExceptionLogExtractor exceptionLogExtractor =
            new ExceptionLogExtractor();

    @Pointcut("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    private void serviceCall() { }

    @Around(value = "serviceCall() && target(target)",
            argNames = "pjp, target")
    public Object collectPerformance(ProceedingJoinPoint pjp, Object target)
            throws Throwable {
        Throwable exception = null;
        Object ret = null;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            ret = pjp.proceed();
        } catch (Throwable t) {
            exception = t;
        }
        stopWatch.stop();

        if (exception == null) {
            this.performanceLogDao.insert(
                    this.performanceLogExtractor.extract(pjp, target),
                    stopWatch.getLastTaskTimeMillis()
            );
        } else {
            this.exceptionLogDao.insert(
                    this.exceptionLogExtractor.extract(pjp, target),
                    exception
            );
        }

        if (exception != null) throw exception;
        return ret;
    }

    public void setPerformanceLogDao(PerformanceLogDao performanceLogDao) {
        this.performanceLogDao = performanceLogDao;
    }

    public void setExceptionLogDao(ExceptionLogDao exceptionLogDao) {
        this.exceptionLogDao = exceptionLogDao;
    }
}
