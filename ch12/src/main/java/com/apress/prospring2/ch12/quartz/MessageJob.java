package com.apress.prospring2.ch12.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Map;

public class MessageJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {

        Map properties = context.getMergedJobDataMap();

        System.out.println("Previous Fire Time: "
                + context.getPreviousFireTime());
        System.out.println("Current Fire Time: " + context.getFireTime());
        System.out.println("Next Fire Time: " + context.getNextFireTime());
        System.out.println(properties.get("message"));
        System.out.println(properties.get("jobDetailData"));
        System.out.println(properties.get("triggerData"));
        System.out.println("");
    }
}
