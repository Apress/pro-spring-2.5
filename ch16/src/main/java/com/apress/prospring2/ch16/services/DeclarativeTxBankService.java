package com.apress.prospring2.ch16.services;

import com.apress.prospring2.ch16.domain.AccountIdentity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author janm
 */
public class DeclarativeTxBankService
        extends BankServiceSupport implements BankService{

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,
            propagation = Propagation.REQUIRED,
            timeout = 600
            
    )
    public void transfer(final AccountIdentity from,
                         final AccountIdentity to,
                         final BigDecimal amount) {
        doTransfer(from, to, amount);
    }

    @Transactional(readOnly = true, timeout = 10)
    public BigDecimal getBalance(AccountIdentity accountIdentity) {
        return doGetBalance(accountIdentity);
    }

}