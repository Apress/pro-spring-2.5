package com.apress.prospring2.ch04.mi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author janm
 */
@Aspect
public class ReplacementAspect {

    @Around("execution(* com.apress.prospring2.ch04.mi.ReplacementTarget.formatMessage(java.lang.String))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        String msg = (String) pjp.getArgs()[0];
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>").append(msg).append("</h2>");
        return sb.toString();
    }
}
