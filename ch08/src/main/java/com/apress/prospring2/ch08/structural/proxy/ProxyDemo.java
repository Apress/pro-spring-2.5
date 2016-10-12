package com.apress.prospring2.ch08.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * @author janm
 */
public class ProxyDemo {

    private void useDao(SimpleDao simpleDao) {
        System.out.println("Using " + simpleDao.getClass().getName());
        simpleDao.insert("Jan");
        simpleDao.insert("Rob");
        try {
            simpleDao.insert(null);
        } catch (Exception e) {
            // expected
        }

        for (String s : simpleDao.getAll()) {
            System.out.println(s);
        }
    }

    private void run() {
        useDao(new RealSimpleDao());
        useDao(new SimpleDaoProxy(new RealSimpleDao()));
        useDao((SimpleDao)Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[] { SimpleDao.class },
                new TransactionalInvocationHandler(new RealSimpleDao())));
    }
    
    public static void main(String[] args) {
        new ProxyDemo().run();
    }
}
