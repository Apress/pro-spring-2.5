package com.apress.prospring2.ch06.introductions;

/**
 * @author janm
 */
public interface CallTracker {

    void markNormal();

    void markFailing();

    int countNormalCalls();

    int countFailingCalls();

    String describe();

}
