package com.apress.prospring2.ch06.simple;

import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionDefinition;

/**
 * @author janm
 */
public class NoopTransactionManager extends AbstractPlatformTransactionManager {

    protected Object doGetTransaction() throws TransactionException {
        return new Object();
    }

    protected void doBegin(Object object, TransactionDefinition transactionDefinition) throws TransactionException {
        System.out.println("Begin");
    }

    protected void doCommit(DefaultTransactionStatus defaultTransactionStatus) throws TransactionException {
        System.out.println("Commit");
    }

    protected void doRollback(DefaultTransactionStatus defaultTransactionStatus) throws TransactionException {
        System.out.println("Rollback");
    }
}
