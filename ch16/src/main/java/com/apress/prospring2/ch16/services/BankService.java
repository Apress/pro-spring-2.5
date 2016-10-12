package com.apress.prospring2.ch16.services;

import com.apress.prospring2.ch16.domain.AccountIdentity;

import java.math.BigDecimal;

/**
 * @author janm
 */
public interface BankService {
    
    void transfer(AccountIdentity from, AccountIdentity to, BigDecimal amount);

    BigDecimal getBalance(AccountIdentity accountIdentity);

}
