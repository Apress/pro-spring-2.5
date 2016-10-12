package com.apress.prospring2.ch08.scheduling;

import java.util.List;

/**
 * This interface provides a unified view of all scheduled jobs within an application and is usable as a services-admin
 * bean and JMX bean.
 * @author janm
 */
public interface SchedulerManager {

    /**
     * Gets all scheduled jobs
     * @return List of all jobs
     */
    List<Job> getJobsDetails();

    /**
     * Triggers a job identified by <code>job</code> for execution now
     * @param job The job to be executed
     */
    void triggerNow(String job);

    /**
     * Indicates whether the scheduler is enabled
     * @return True if jobs will be executed
     */
    boolean isEnabled();

    /**
     * Sets whether the scheduler is enabled or not
     * @param enabled True if jobs can be executed
     */
    void setEnabled(boolean enabled);

}
