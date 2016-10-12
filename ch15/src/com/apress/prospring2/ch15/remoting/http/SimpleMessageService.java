package com.apress.prospring2.ch15.remoting.http;

import com.apress.prospring2.ch15.remoting.MessageBean;
import com.apress.prospring2.ch15.remoting.MessageService;

/**
 * @author aleksav
 */
public class SimpleMessageService implements MessageService {

    public MessageBean getMessage() {
        MessageBean mb = new MessageBean();
        mb.setMessage("Hello World!");
        mb.setSenderName("Superman");

        return mb;
    }

}
