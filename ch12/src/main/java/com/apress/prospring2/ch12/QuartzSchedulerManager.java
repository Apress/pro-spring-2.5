package com.apress.prospring2.ch12;

import org.quartz.Scheduler;
import org.springframework.jmx.export.annotation.*;

/**
 * @author janm
 */
@ManagedResource(objectName = "com.apress.prospring2.ch12:name=SchedulerManager")
public class QuartzSchedulerManager implements SchedulerManager {
    private Scheduler scheduler;

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @ManagedAttribute(description = "Lists the jobs")
    public String[] getJobs() {
        return new String[0];
    }

    @ManagedOperation(description = "Triggers a job immediately")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "job", description = "The job name")
    })
    public void triggerNow(String job) {
        System.out.println("run");
    }
}
