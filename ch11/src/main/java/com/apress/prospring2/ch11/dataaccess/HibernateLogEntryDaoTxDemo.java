package com.apress.prospring2.ch11.dataaccess;

import com.apress.prospring2.ch11.domain.LogEntry;
import com.apress.prospring2.ch11.util.DaoDemoUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * @author janm
 */
public class HibernateLogEntryDaoTxDemo {

    private static LogEntry save(LogEntryDao dao, String name) {
        LogEntry le = new LogEntry();
        le.setName(name);
        le.setDate(Calendar.getInstance().getTime());
        dao.save(le);
        return le;
    }

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource-context-dao.xml", DaoDemo.class);
        LogEntryDao logEntryDao = (LogEntryDao) ac.getBean("logEntryDao");

        try {
            save(logEntryDao, "Hello, this works");
            save(logEntryDao, null);
        } catch (Exception e) {
            // we don't want anything here, but Alas!
            System.out.println(logEntryDao.getAll());
        }
    }

}