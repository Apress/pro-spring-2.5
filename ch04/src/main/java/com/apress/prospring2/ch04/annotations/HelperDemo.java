package com.apress.prospring2.ch04.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author janm
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HelperDemo {
    @Autowired
    private Helper helper;

    public void setHelper(Helper helper) {
        this.helper = helper;
    }

    public void someOperation() {
        this.helper.work();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HelperDemo");
        sb.append("{helper=").append(helper);
        sb.append('}');
        return sb.toString();
    }
}
