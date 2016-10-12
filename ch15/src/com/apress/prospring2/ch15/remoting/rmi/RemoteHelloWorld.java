package com.apress.prospring2.ch15.remoting.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author aleksav
 */
public interface RemoteHelloWorld extends Remote {

    String getMessage() throws RemoteException;

   

}
