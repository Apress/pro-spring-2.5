package com.apress.prospring2.ch15.remoting.jaxws;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebService;
import javax.jws.WebMethod;

import com.apress.prospring2.ch15.remoting.rmi.RemoteHelloWorld;
import com.apress.prospring2.ch15.remoting.HelloWorld;

/**
 * Created by aleksav
 */
@WebService
public class JaxWsHelloWorld extends SpringBeanAutowiringSupport implements RemoteHelloWorld {
    @Autowired
    private HelloWorld helloWorld;

    @WebMethod
    public String getMessage() throws RemoteException {
        return helloWorld.getMessage();
    }
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
    @WebMethod
    public List getList() throws RemoteException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
}
}
