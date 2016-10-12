package com.apress.prospring2.ch03.beandependency;

/**
 * @author janm
 */
public class A {

    public A() {
        Shared.setValue("Undetermined");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("{}");
        sb.append("Shared.getValue()=").append(Shared.getValue()).append("}");
        return sb.toString();
    }
}
