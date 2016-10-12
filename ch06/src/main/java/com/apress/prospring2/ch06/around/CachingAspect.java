package com.apress.prospring2.ch06.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author janm
 */
@Aspect
public class CachingAspect {
    private Map<MethodAndArguments, Object> cache =
            Collections.synchronizedMap(
                    new HashMap<MethodAndArguments, Object>());
    private Object nullValue = new Object();

    private static class MethodAndArguments {
        private Object target;
        private Object[] arguments;

        private MethodAndArguments(Object target, Object[] arguments) {
            this.target = target;
            this.arguments = arguments;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MethodAndArguments that = (MethodAndArguments) o;

            return Arrays.equals(arguments, that.arguments) && target.equals(that.target);
        }

        public int hashCode() {
            int result;
            result = target.hashCode();
            result = 31 * result + Arrays.hashCode(arguments);
            return result;
        }
    }

    @Around("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    public Object cacheCalls(ProceedingJoinPoint pjp) throws Throwable {
        Object cacheRet;
        final MethodAndArguments methodAndArguments = new MethodAndArguments(pjp.getTarget(), pjp.getArgs());
        cacheRet = this.cache.get(methodAndArguments);
        if (cacheRet == this.nullValue) return null;
        if (cacheRet == null) {
            Object ret = pjp.proceed();
            cacheRet = ret;
            if (cacheRet == null) cacheRet = this.nullValue;
            this.cache.put(methodAndArguments, cacheRet);
            return ret;
        }
        return cacheRet;
    }

}
