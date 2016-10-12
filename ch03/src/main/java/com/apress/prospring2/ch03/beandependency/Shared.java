package com.apress.prospring2.ch03.beandependency;

/**
 * @author janm
 */
public final class Shared {
    private static Object value = null;
    private Shared() {

    }

    public synchronized static void setValue(Object o) {
        value = o;
    }

    public static Object getValue() {
        return value;
    }
}
