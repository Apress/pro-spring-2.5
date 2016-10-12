package com.apress.prospring2.ch07.motivation;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * @author anirvanc
 */
public class NoopPlatformTransactionManager extends AbstractPlatformTransactionManager {

    @Override
	protected Object doGetTransaction() throws TransactionException {
        return new Object();
    }

    @Override
	protected void doBegin(Object object, TransactionDefinition transactionDefinition) throws TransactionException {
        // noop
    }

    @Override
	protected void doCommit(DefaultTransactionStatus defaultTransactionStatus) throws TransactionException {
        // noop
    }

    @Override
	protected void doRollback(DefaultTransactionStatus defaultTransactionStatus) throws TransactionException {
        // noop
    }
}
