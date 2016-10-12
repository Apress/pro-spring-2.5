package com.apress.prospring2.ch06.practical;

import org.aspectj.lang.JoinPoint;

/**
 * @author janm
 */
final class PerformanceLogExtractor {

    PerformanceLog extract(JoinPoint pjp, Object target) {
        return new PerformanceLog();
    }

}
