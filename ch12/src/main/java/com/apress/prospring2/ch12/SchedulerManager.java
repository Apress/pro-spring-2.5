package com.apress.prospring2.ch12;

/**
 * @author janm
 */
public interface SchedulerManager {

    String[] getJobs();

    void triggerNow(final String job);

}
