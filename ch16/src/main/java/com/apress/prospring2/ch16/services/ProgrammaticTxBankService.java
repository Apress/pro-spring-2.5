package com.apress.prospring2.ch16.services;

import com.apress.prospring2.ch16.domain.AccountIdentity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

/**
 * @author janm
 */
public class ProgrammaticTxBankService
        extends BankServiceSupport implements BankService{
    private TransactionTemplate transactionTemplate;

    public void transfer(final AccountIdentity from,
                         final AccountIdentity to,
                         final BigDecimal amount) {
        this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                doTransfer(from, to, amount);
            }
        });
    }

    public BigDecimal getBalance(AccountIdentity accountIdentity) {
        return doGetBalance(accountIdentity);
    }

    public void setTransactionManager(
            PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }
}
