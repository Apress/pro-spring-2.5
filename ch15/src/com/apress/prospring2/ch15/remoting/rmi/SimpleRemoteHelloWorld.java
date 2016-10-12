package com.apress.prospring2.ch15.remoting.rmi;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author aleksav
 */
public class SimpleRemoteHelloWorld implements RemoteHelloWorld {

    public String getMessage() throws RemoteException {
        return "Hello World";
    }
    public List getList() throws RemoteException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}