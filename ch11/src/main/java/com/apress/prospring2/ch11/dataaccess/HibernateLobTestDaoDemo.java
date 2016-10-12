package com.apress.prospring2.ch11.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring2.ch11.util.DaoDemoUtils;
import com.apress.prospring2.ch11.domain.LobTest;

/**
 * @author janm
 */
public class HibernateLobTestDaoDemo {

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource-context-tx.xml", DaoDemo.class);
        LobTestDao lobTestDao = (LobTestDao)ac.getBean("lobTestDao");

        LobTest lobTest = new LobTest();
        lobTest.setTextContent("Hello, world");
        lobTest.setBinaryContent("Hello, world".getBytes());
        lobTest.setMimeType("text/plain");
        lobTestDao.save(lobTest);

        LobTest lobTest2 = lobTestDao.getById(lobTest.getId());
        System.out.println(lobTest2);
    }

}