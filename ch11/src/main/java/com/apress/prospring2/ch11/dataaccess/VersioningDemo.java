package com.apress.prospring2.ch11.dataaccess;

import com.apress.prospring2.ch11.domain.LogEntry;
import com.apress.prospring2.ch11.util.DaoDemoUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * @author janm
 */
public class VersioningDemo {

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource-context-dao.xml", DaoDemo.class);
        LogEntryDao logEntryDao = (LogEntryDao) ac.getBean("logEntryDao");
        // save the original entry
        LogEntry le = new LogEntry();
        le.setName("Name");
        le.setDate(Calendar.getInstance().getTime());
        logEntryDao.save(le);

        // load two instances of the same LogEntry object
        LogEntry le1 = logEntryDao.getById(le.getId());
        LogEntry le2 = logEntryDao.getById(le.getId());
        // modify & save le1
        le1.setName("X");
        logEntryDao.save(le1);
        // now, let's try to modify & and save le2.
        // remember, le2 represents the same row as le1
        le2.setName("Z");
        logEntryDao.save(le2);
    }
}
