package com.apress.prospring2.ch16.synchronization;

import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

/**
 * @author janm
 */
public class WorkerFactoryContext {
    private Worker worker;

    public WorkerFactoryContext(Worker worker) {
        Assert.notNull(worker, "The argument 'worker' must not be null.");
        this.worker = worker;
    }

    public static WorkerFactoryContext getContext(WorkerFactory workerFactory) {
        if (TransactionSynchronizationManager.isSynchronizationActive() &&
                TransactionSynchronizationManager.hasResource(workerFactory)) {

            WorkerFactoryContext context =
                    (WorkerFactoryContext) TransactionSynchronizationManager.
                            getResource(workerFactory);
            if (context == null) {
                throw new IllegalStateException(String.format(
                        "Null WorkerFactoryContext bound as " +
                                "transactional resource for [%s].",
                        workerFactory));
            }
            return context;
        }
        throw new IllegalStateException(String.format(
                "Cannot access WorkerFactoryContext for [%s] when " +
                        "transaction synchronozation is not active.",
                workerFactory));
    }

    public Worker getWorker() {
        return worker;
    }
}
