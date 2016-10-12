package com.apress.prospring2.ch06.practical;

import org.aspectj.lang.JoinPoint;

/**
 * @author janm
 */
public class ExceptionLogExtractor {
    public ExceptionLog extract(JoinPoint pjp, Object target) {
        return new ExceptionLog();
    }
}
