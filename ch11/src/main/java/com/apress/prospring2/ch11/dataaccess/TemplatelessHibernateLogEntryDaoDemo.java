package com.apress.prospring2.ch11.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring2.ch11.util.DaoDemoUtils;

/**
 * @author janm
 */
public class TemplatelessHibernateLogEntryDaoDemo {

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource-context-dao.xml", DaoDemo.class);
        LogEntryDao logEntryDao = (LogEntryDao) ac.getBean("templatelessLogEntryDao");
        logEntryDao.getAll();

        logEntryDao.getByName("X");
    }

}