package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.domain.LobTest;
import com.apress.prospring2.ch11.util.DaoDemoUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author janm
 */
public class LobTestServiceDemo {

    private void run() throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
            "classpath*:/com/apress/prospring2/ch11/dataaccess/datasource-context-tx.xml",
            "classpath*:/com/apress/prospring2/ch11/service/*-context.xml"
        });
        LobTestService lobTestService = (LobTestService)ac.getBean("lobTestService");
        LobTest lobTest = new LobTest();
        lobTest.setTextContent("Hello, world");
        lobTest.setBinaryContent("Hello, world".getBytes());
        lobTest.setMimeType("text/plain");
        lobTestService.save(lobTest);

        LobTest lobTest2 = lobTestService.findById(lobTest.getId());
        System.out.println(lobTest2);
    }

    public static void main(String[] args) throws Exception {
        new LobTestServiceDemo().run();
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}