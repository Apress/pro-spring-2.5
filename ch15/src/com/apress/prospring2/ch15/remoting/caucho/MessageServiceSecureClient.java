package com.apress.prospring2.ch15.remoting.caucho;

import com.apress.prospring2.ch15.remoting.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author aleksav
 */
public class MessageServiceSecureClient {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/caucho/messageServiceSecure.xml");

        MessageService messageService = (MessageService) ctx
                .getBean("messageService");
        System.out.println(messageService.getMessage());
    }
}
