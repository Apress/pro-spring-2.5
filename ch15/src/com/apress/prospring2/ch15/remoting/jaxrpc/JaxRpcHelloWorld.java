package com.apress.prospring2.ch15.remoting.jaxrpc;

import com.apress.prospring2.ch15.remoting.HelloWorld;
import com.apress.prospring2.ch15.remoting.rmi.RemoteHelloWorld;
import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aleksav
 */
public class JaxRpcHelloWorld extends ServletEndpointSupport implements
        RemoteHelloWorld {

    private HelloWorld helloWorld;

    protected void onInit() throws ServiceException {
        helloWorld = (HelloWorld) getApplicationContext().getBean(
                "helloWorldService");
    }

    public String getMessage() throws RemoteException {
        return helloWorld.getMessage();
    }

    public List getList() throws RemoteException {
        List<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("aleksa");
        return list;
    }

}