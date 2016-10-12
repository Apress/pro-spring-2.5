package com.apress.prospring2.ch15.remoting.jaxrpc;


import com.apress.prospring2.ch15.remoting.MessageBean;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author aleksav
 */
public interface MessageService extends Remote {

    MessageBean getMessage() throws RemoteException;
}
