package com.apress.prospring2.ch12.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.StdScheduler;

public class HelloWorldScheduling {

    public static void main(String[] args) throws SchedulerException {

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        JobDetail jobDetail = new JobDetail("helloWorldJob",
                Scheduler.DEFAULT_GROUP, HelloWorldJob.class);

        Trigger trigger = new SimpleTrigger();
    }
}
