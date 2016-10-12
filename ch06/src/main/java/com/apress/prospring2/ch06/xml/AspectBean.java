package com.apress.prospring2.ch06.xml;

import com.apress.prospring2.ch06.introductions.CallTracker;
import com.apress.prospring2.ch06.services.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author janm
 */
public class AspectBean {

    public Object censorStringArguments(ProceedingJoinPoint pjp, String argument) throws Throwable {
        Object[] arguments;
        if (argument != null) {
            System.out.println("censored " + argument + "!");
            arguments = new Object[] { "****" };
        } else {
            arguments = new Object[] { null };
        }
        return pjp.proceed(arguments);
    }

    public void logCall(JoinPoint jp) {
        System.out.println(jp);
    }

    public void after(UserService target) {
        System.out.println("after call to " + target);
    }

    public void healthMonitoring(Object target, NullPointerException ex) {
        System.out.println("Target " + target + " has thrown " + ex);
    }

    public Object auditCall(Object target, Object ret) {
        System.out.println("After method call of " + target + ", returning " + ret);
        if (ret instanceof Long) {
            ret = 1L;
        }
        return ret;
    }

    public void normalCall(CallTracker tracker) {
        tracker.markNormal();
    }

    public void failingCall(CallTracker tracker) {
        tracker.markFailing();
    }

}
