package com.apress.prospring2.ch03.beandependency;

/**
 * @author janm
 */
public class B {

    public B() {
        Shared.setValue("Completed");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("B");
        sb.append("{}");
        sb.append("Shared.getValue()=").append(Shared.getValue()).append("}");
        return sb.toString();
    }
}
