package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.util.DaoDemoUtils;
import com.apress.prospring2.ch11.dataaccess.LogEntryDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class SampleServiceDemo {

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
            "classpath*:/com/apress/prospring2/ch11/dataaccess/datasource-context-tx.xml",
            "classpath*:/com/apress/prospring2/ch11/service/*-context.xml"
        });
        SampleService sampleService = (SampleService)ac.getBean("sampleService");
        LogEntryDao logEntryDao = (LogEntryDao) ac.getBean("logEntryDao");
        int successCount = 0;
        int failureCount = 0;
        int before = logEntryDao.getAll().size();
        for (int i = 0; i < 10; i++) {
            if (tryWork(sampleService)) {
                successCount++;
            } else {
                failureCount++;
            }
        }
        System.out.println("Inserted " + (logEntryDao.getAll().size() - before) + ", for " + successCount + " successes and " + failureCount + " failures");
    }

    private static boolean tryWork(SampleService sampleService) {
        try {
            sampleService.work();
            return true;
        } catch (Exception e) {
            // do nothing (BAD in production)
        }
        return false;
    }

}
