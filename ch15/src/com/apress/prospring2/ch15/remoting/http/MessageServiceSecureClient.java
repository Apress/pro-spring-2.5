package com.apress.prospring2.ch15.remoting.http;

import com.apress.prospring2.ch15.remoting.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author aleksav
 */
public class MessageServiceSecureClient {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/http/messageServiceSecure.xml");

        MessageService messageService = (MessageService) ctx
                .getBean("messageService");
        System.out.println(messageService.getMessage());
    }
}
