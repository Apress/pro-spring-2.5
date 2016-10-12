package com.apress.prospring2.ch06.binding;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;
import java.math.BigDecimal;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author janm
 */
@Aspect
public class BindingAspect {

    @Around(value =
            "execution(* com.apress.prospring2.ch06.services.DefaultStockService.*(..)) &&" +
            "args(cutoffDate, minimumDiscount)",
            argNames = "pjp, cutoffDate, minimumDiscount")
    public Object discountEnforcement(ProceedingJoinPoint pjp, Date cutoffDate,
                                      BigDecimal minimumDiscount)
            throws Throwable {

        new InvocationHandler() {

            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        return pjp.proceed();
    }
}
