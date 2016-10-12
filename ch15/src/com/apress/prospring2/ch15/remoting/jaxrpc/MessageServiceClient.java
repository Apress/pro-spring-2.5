package com.apress.prospring2.ch15.remoting.jaxrpc;

import com.apress.prospring2.ch15.remoting.MessageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * @author aleksav
 */
public class MessageServiceClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/jaxrpc/messageServiceClient.xml");
        MessageService service = (MessageService) ctx.getBean("messageService");
        MessageBean bean = service.getMessage();
        System.out.println(bean);
    }
}
