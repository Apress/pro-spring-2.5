package com.apress.prospring2.ch06.introductions;

import org.aspectj.lang.annotation.*;

/**
 * @author janm
 */
@Aspect
public class CallTrackerAspect {

    @Pointcut("execution(* com.apress.prospring2.ch06.services.*.*(..))")
    private void setterServiceCall() { }

    @DeclareParents(
        value = "com.apress.prospring2.ch06.services.*",
        defaultImpl = DefaultCallTracker.class)
    public static CallTracker mixin;

    @AfterReturning(
        value = "setterServiceCall() && this(tracker)",
        argNames = "tracker")
    public void normalCall(CallTracker tracker) {
        tracker.markNormal();
    }

    @AfterThrowing(
        value = "setterServiceCall() && this(tracker)",
        throwing = "t",
        argNames = "tracker, t")
    public void failingCall(CallTracker tracker, Throwable t) {
        tracker.markFailing();
    }

}
