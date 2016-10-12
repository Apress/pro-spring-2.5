package com.apress.prospring2.ch06.introductions;

/**
 * @author janm
 */
public class DefaultCallTracker implements CallTracker {
    private int normalCalls;
    private int failingCalls;

    public void markNormal() {
        this.normalCalls++;
    }

    public void markFailing() {
        this.failingCalls++;
    }

    public int countNormalCalls() {
        return this.normalCalls;
    }

    public int countFailingCalls() {
        return this.failingCalls;
    }

    public String describe() {
        return toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DefaultCallTracker");
        sb.append("{normalCalls=").append(normalCalls);
        sb.append(", failingCalls=").append(failingCalls);
        sb.append('}');
        return sb.toString();
    }
}
