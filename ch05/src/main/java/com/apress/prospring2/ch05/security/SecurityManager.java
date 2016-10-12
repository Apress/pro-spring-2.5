package com.apress.prospring2.ch05.security;

/**
 * @author janm
 */
public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();

    public void login(String username, String password) {
        // assumes that all credentials
        // are valid for a login
        threadLocal.set(new UserInfo(username, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }
}
