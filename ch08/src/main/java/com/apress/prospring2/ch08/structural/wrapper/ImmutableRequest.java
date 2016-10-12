package com.apress.prospring2.ch08.structural.wrapper;

import java.util.Map;

/**
 * @author janm
 */
public final class ImmutableRequest implements Request {
    private String action;
    private Map<String, Object> arguments;

    public ImmutableRequest(final String action) {
        this.action = action;
    }

    public final void addArgument(final String name, final Object value) {
        this.arguments.put(name, value);
    }

    public final Object getArgument(final String name) {
        return this.arguments.get(name);
    }

    public final String getAction() {
        return this.action;
    }
}
