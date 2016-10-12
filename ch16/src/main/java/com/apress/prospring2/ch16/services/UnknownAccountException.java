package com.apress.prospring2.ch16.services;

import com.apress.prospring2.ch16.domain.AccountIdentity;
import org.springframework.core.NestedRuntimeException;

/**
 * @author janm
 */
public class UnknownAccountException extends NestedRuntimeException {
    private static final long serialVersionUID = -5705813683661824922L;
    private AccountIdentity identity;

    public UnknownAccountException(AccountIdentity identity) {
        super("Unknown account");
        this.identity = identity;
    }

    public AccountIdentity getIdentity() {
        return identity;
    }
}
