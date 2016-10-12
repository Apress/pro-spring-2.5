package com.apress.prospring2.ch04.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author janm
 */
@Component("mostComplicatedBean")
@Scope("prototype")
public class SimplestBean {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SimplestBean");
        sb.append("{}");
        return sb.toString();
    }
}