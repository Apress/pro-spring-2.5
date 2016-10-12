package com.apress.prospring2.ch16.standalone;

import com.apress.prospring2.ch16.services.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class TxSynchronizationMain {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[] {
                        "/META-INF/spring/*-context.xml",
                        "/META-INF/spring/*-context-worker.xml"
                }
        );
        AccountService accountService = (AccountService) ac.getBean("accountService");
        try {
            accountService.create();
        } catch (Exception ignored) {
            
        }
    }

}