package com.apress.prospring2.ch08.scheduling;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.jmx.export.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author janm
 */
@ManagedResource(objectName = "com.apress.prospring2.ch08.scheduling:name=manager", description = "The scheduler manager")
public class QuartzSchedulerManager implements SchedulerManager {
    private Scheduler scheduler;
    private static final Pattern JOB_NAME_PATTERN = Pattern.compile("([^:]*)::(.*)");

    public List<Job> getJobsDetails() {
        try {
            List<Job> result = new LinkedList<Job>();
            String[] groups = this.scheduler.getJobGroupNames();
            for (String group : groups) {
                String[] names = this.scheduler.getJobNames(group);
                for (String name : names) {
                    Job job = new Job(String.format("%s::%s", group, name));
                    job.setEnabled(true);
                    result.add(job);
                }
            }
            return result;
        } catch (SchedulerException ex) {
            throw new RuntimeException(ex);
        }
    }

    @ManagedAttribute(description = "The scheduled jobs")
    public String[] getJobs() {
        try {
            List<String> result = new LinkedList<String>();
            String[] groups = this.scheduler.getJobGroupNames();
            for (String group : groups) {
                String[] names = this.scheduler.getJobNames(group);
                for (String name : names) {
                    result.add(String.format("%s::%s", group, name));
                }
            }
            return result.toArray(new String[result.size()]);
        } catch (SchedulerException ex) {
            throw new RuntimeException(ex);
        }
    }

    @ManagedOperation(description = "Trigger a job identified by the argument now")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "job", description = "The job name")
    })
    public void triggerNow(String job) {
        Matcher matcher = JOB_NAME_PATTERN.matcher(job);
        if (matcher.matches()) {
            try {
                this.scheduler.triggerJob(matcher.group(2), matcher.group(1));
            } catch (SchedulerException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @ManagedAttribute(description = "Indicates whether the scheduler is enabled")
    public boolean isEnabled() {
        return true;
    }

    @ManagedOperation(description = "Enables or disables the scheduler")
    @ManagedOperationParameters({
        @ManagedOperationParameter(name = "enabled", description = "Enable or disable")
    })
    public void setEnabled(boolean enabled) {
        // noop
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
