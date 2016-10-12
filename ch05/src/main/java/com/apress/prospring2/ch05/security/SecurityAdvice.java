package com.apress.prospring2.ch05.security;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author janm
 */
public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException(
                    "You must login before attempting to invoke the method: "
                            + method.getName());
        } else if ("janm".equals(user.getUsername())) {
            System.out.println("Logged in user is janm - OKAY!");
        } else {
            System.out.println("Logged in user is " + user.getUsername()
                    + " NOT GOOD :(");
            throw new SecurityException("User " + user.getUsername()
                    + " is not allowed access to method " + method.getName());
        }

    }
}
