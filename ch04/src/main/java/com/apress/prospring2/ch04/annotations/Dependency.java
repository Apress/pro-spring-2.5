package com.apress.prospring2.ch04.annotations;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author janm
 */
@Component
public class Dependency {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Dependency");
        sb.append(ObjectUtils.identityToString(this));
        sb.append("{}");
        return sb.toString();
    }
}
