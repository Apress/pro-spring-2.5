package com.apress.prospring2.ch04.annotations;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author janm
 */
@Component("helper")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Helper {
    private int count;

    public void work() {
        this.count++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Helper");
        sb.append("{count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
