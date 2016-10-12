package com.apress.prospring2.ch12.quartz;

import org.quartz.Scheduler;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Map;
import java.util.Date;

public class TriggerMessageScheduling {

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        JobDetail jobDetail = new JobDetail("triggerMessageJob",
                Scheduler.DEFAULT_GROUP, MessageJob.class);
        jobDetail.getJobDataMap().put("jobDetailData", "My job details data.");

        Trigger trigger = new SimpleTrigger("simpleTrigger",
                Scheduler.DEFAULT_GROUP, new Date(), null,
                SimpleTrigger.REPEAT_INDEFINITELY, 3000);
        Map map = trigger.getJobDataMap();
        map.put("message", "Message from Trigger");
        map.put("triggerData", "My trigger data.");

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
