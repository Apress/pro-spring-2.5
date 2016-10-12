package com.apress.prospring2.ch15.remoting.jaxrpc;

import com.apress.prospring2.ch15.remoting.MessageBean;

import java.rmi.RemoteException;

/**
 * @author aleksav
 */
public class JaxRpcMessageService implements MessageService {

    public MessageBean getMessage() throws RemoteException {
        MessageBean bean = new MessageBean();
        bean.setMessage("Hello World!");
        bean.setSenderName("Mr No");
        return bean;
    }

}
