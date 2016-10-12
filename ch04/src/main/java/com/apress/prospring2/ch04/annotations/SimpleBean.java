package com.apress.prospring2.ch04.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * @author janm
 */
@Magic
public class SimpleBean {
    private Dependency dependency;

    @Autowired(required = true)
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SimpleBean");
        sb.append(ObjectUtils.identityToString(this));
        sb.append("{dependency=").append(dependency);
        sb.append('}');
        return sb.toString();
    }
}
