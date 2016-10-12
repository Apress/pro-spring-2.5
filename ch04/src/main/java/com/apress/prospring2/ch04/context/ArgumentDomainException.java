package com.apress.prospring2.ch04.context;

import org.springframework.core.NestedRuntimeException;

/**
 * @author janm
 */
public class ArgumentDomainException extends NestedRuntimeException {
    private static final long serialVersionUID = 4589477591557787475L;
    private double argument;

    public ArgumentDomainException(String msg, double argument) {
        super(msg);
        this.argument = argument;
    }

    public double getArgument() {
        return argument;
    }
}
