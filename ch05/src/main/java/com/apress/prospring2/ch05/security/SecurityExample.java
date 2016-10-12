package com.apress.prospring2.ch05.security;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author janm
 */
public class SecurityExample {

    public static void main(String[] args) {
        // get the security manager
        SecurityManager mgr = new SecurityManager();

        // get the bean
        SecureBean bean = getSecureBean();

        // try as robh
        mgr.login("janm", "*****");
        bean.writeSecureMessage();
        mgr.logout();

        // try as janm
        try {
            mgr.login("mallory", "****");
            bean.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        // try with no credentials
        try {
            bean.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }

    }

    private static SecureBean getSecureBean() {
        // create the target
        SecureBean target = new SecureBean();

        // create the advice
        SecurityAdvice advice = new SecurityAdvice();

        // get the proxy
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        return (SecureBean)factory.getProxy();

    }
}
