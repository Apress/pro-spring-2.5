package com.apress.prospring2.ch12.quartz;

import org.quartz.impl.calendar.HolidayCalendar;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.Scheduler;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.CronTrigger;

import java.util.Map;
import java.util.Calendar;

public class CronWithCalendarExample {
    public static void main(String[] args) throws Exception {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        // create a calendar to exclude a particular date
        Calendar cal = Calendar.getInstance();
        cal.set(2007, Calendar.DECEMBER, 25);

        HolidayCalendar calendar = new HolidayCalendar();
        calendar.addExcludedDate(cal.getTime());

        // add to scheduler
        scheduler.addCalendar("xmasCalendar", calendar, true, false);

        JobDetail jobDetail = new JobDetail("messageJob",
                Scheduler.DEFAULT_GROUP, MessageJob.class);

        Map map = jobDetail.getJobDataMap();
        map.put("message", "This is a message from Quartz");

        String cronExpression = "3/5 * 14,15,16,17 * * ?";

        Trigger trigger = new CronTrigger("cronTrigger",
                Scheduler.DEFAULT_GROUP, cronExpression);

        trigger.setCalendarName("xmasCalendar");

        scheduler.scheduleJob(jobDetail, trigger);
    }

}
