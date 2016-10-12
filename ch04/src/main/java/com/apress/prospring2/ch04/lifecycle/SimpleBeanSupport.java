package com.apress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * @author janm
 */
public abstract class SimpleBeanSupport implements InitializingBean {
    private String value;

    /**
     * Subclasses may override this method to perform additional initialization.
     * This method gets invoked after the initialization of the {@link SimpleBeanSupport}
     * completes.
     * @throws Exception If the subclass initialization fails.
     */
    protected void initSimple() throws Exception {
        // do nothing
    }

    public final void afterPropertiesSet() throws Exception {
        Assert.notNull(this.value, "The [value] property of [" + getClass().getName() + "] must be set.");
        initSimple();
    }

    public final void setValue(String value) {
        this.value = value;
    }

    protected final String getValue() {
        return this.value;
    }
}
