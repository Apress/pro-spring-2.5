package com.apress.prospring2.ch16.synchronization;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author janm
 */
public class WorkerTransactionSynchronization extends TransactionSynchronizationAdapter {
    private WorkerFactory workerFactory;

    public WorkerTransactionSynchronization(WorkerFactory workerFactory) {
        this.workerFactory = workerFactory;
    }

    @Override
    public void afterCompletion(int status) {
        if (!TransactionSynchronizationManager.hasResource(this.workerFactory)) {
            throw new IllegalStateException(String.format(
                    "Required synchronization resource missing under key '%s'.",
                    this.workerFactory));
        }
        WorkerFactoryContext context = WorkerFactoryContext.
                getContext(this.workerFactory);
        Worker worker = context.getWorker();
        try {
            if (STATUS_COMMITTED == status) {
                worker.commit();
            } else {
                worker.rollback();
            }
        } finally {
            TransactionSynchronizationManager.unbindResource(this.workerFactory);
        }
    }
}
