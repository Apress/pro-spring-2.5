package com.apress.prospring2.ch16.synchronization;

/**
 * @author janm
 */
public interface Worker {

    void work(int value);

    void commit();

    void rollback();
}
