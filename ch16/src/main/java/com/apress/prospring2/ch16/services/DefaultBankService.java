package com.apress.prospring2.ch16.services;

import com.apress.prospring2.ch16.domain.AccountIdentity;

import java.math.BigDecimal;

/**
 * @author janm
 */
public class DefaultBankService extends BankServiceSupport
        implements BankService {

    public void transfer(AccountIdentity from, AccountIdentity to,
                         BigDecimal amount) {
        if (getBalance(to).compareTo(new BigDecimal("1000000000")) > 0) {
            throw new RuntimeException("Billionaires do not need more money!");
        }
        doTransfer(from, to, amount);
    }

    public BigDecimal getBalance(AccountIdentity accountIdentity) {
        return doGetBalance(accountIdentity);
    }
}