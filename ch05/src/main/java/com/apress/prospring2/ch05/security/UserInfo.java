package com.apress.prospring2.ch05.security;

/**
 * @author janm
 */
public class UserInfo {
    private String username;
    private String password;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }
}
