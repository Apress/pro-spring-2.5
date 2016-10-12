package com.apress.prospring2.ch03.autowiring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author janm
 */
public class AnnotatedTarget {
    @Autowired
    private Foo foo;
    @Autowired
    private Foo foo2;
    @Autowired
    private Bar bar;
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AnnotatedTarget");
        sb.append("{foo=").append(foo);
        sb.append(", foo2=").append(foo2);
        sb.append(", bar=").append(bar);
        sb.append('}');
        return sb.toString();
    }
}