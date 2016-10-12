package com.apress.prospring2.ch08.errorreporting;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.IOException;

/**
 * @author janm
 */
@Aspect
public class ErrorLoggingAroundAspect {
    private ErrorLogDao errorLogDao;

    @Around("execution(* com.apress.prospring2.ch08.errorreporting.*Service.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        pjp.getSignature().getName();
        try {
            return pjp.proceed();
        } catch (Throwable t) {
            insertThrowable(t, pjp);
            throw t;
        }
    }

    private void insertThrowable(Throwable t, ProceedingJoinPoint pjp) throws IOException {
        StringWriter writer = new StringWriter();
        t.printStackTrace(new PrintWriter(writer));
        writer.close();
        StringBuilder sb = new StringBuilder();
        for (Object argument : pjp.getArgs()) {
            if (sb.length() > 0) sb.append(",");
            sb.append(argument);
        }
        sb.insert(0, "(");
        sb.insert(0, pjp.getSignature().getName());
        this.errorLogDao.insert(writer.toString(), sb.toString());
    }

    public void setErrorLogDao(ErrorLogDao errorLogDao) {
        this.errorLogDao = errorLogDao;
    }
}
