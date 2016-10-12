package com.apress.prospring2.ch16.synchronization;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author janm
 */
public class TransactionAwareWorkerFactory implements WorkerFactory {

    public TransactionAwareWorkerFactory() {
    }

    public Worker create() {
        if (TransactionSynchronizationManager.hasResource(this)) {
            return getTransactionBoundWorker();
        } else {
            return createNewTransactionBoundWorker();
        }
    }

    private Worker createNewTransactionBoundWorker() {
        Worker worker = new DefaultWorker();
        WorkerFactoryContext context = new WorkerFactoryContext(worker);

        TransactionSynchronization synchronization =
                new WorkerTransactionSynchronization(this);
        TransactionSynchronizationManager.registerSynchronization(synchronization);
        TransactionSynchronizationManager.bindResource(this, context);

        return worker;
    }


    private Worker getTransactionBoundWorker() {
        WorkerFactoryContext context = (WorkerFactoryContext)
                TransactionSynchronizationManager.getResource(this);
        return context.getWorker();
    }


}
