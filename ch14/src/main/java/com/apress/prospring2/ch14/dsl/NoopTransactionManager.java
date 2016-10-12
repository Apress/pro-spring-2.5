package com.apress.prospring2.ch14.dsl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

/**
 * @author janm
 */
public class NoopTransactionManager implements PlatformTransactionManager {
    private static final Log logger = LogFactory.getLog(NoopTransactionManager.class);

    public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
        return new SimpleTransactionStatus();
    }

    public void commit(TransactionStatus transactionStatus) throws TransactionException {
        logger.info("commit");
    }

    public void rollback(TransactionStatus transactionStatus) throws TransactionException {
        logger.info("rollback");
    }
}
