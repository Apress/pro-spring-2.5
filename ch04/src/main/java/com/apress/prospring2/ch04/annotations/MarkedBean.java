package com.apress.prospring2.ch04.annotations;

/**
 * @author janm
 */
public class MarkedBean implements ComponentMarker {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MarkedBean");
        sb.append("{}");
        return sb.toString();
    }
}
