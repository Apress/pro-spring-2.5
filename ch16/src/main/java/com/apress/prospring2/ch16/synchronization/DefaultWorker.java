package com.apress.prospring2.ch16.synchronization;

/**
 * @author janm
 */
public class DefaultWorker implements Worker {
    private int value;

    public void work(int value) {
        this.value = value;
    }

    public void commit() {
        System.out.println("Committing " + value);
    }

    public void rollback() {
        System.out.println("Rolling back " + value);
    }

}
