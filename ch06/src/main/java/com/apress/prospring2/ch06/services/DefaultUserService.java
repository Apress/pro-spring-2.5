package com.apress.prospring2.ch06.services;

import com.apress.prospring2.ch06.common.SecurityContext;
import com.apress.prospring2.ch06.common.User;

/**
 * @author janm
 */
public class DefaultUserService implements UserService {
    private String administratorUsername = "janm";

    public void login(String username) {
        if (this.administratorUsername.equals(username)) {
            SecurityContext.setCurrentUser(username);
        }
    }

    public void setAdministratorUsername(String administratorUsername) {
        this.administratorUsername = administratorUsername;
    }

    public User findById(long id) {
        User user = new User();
        user.setUsername(String.valueOf(id));
        user.setPassword("Very secret password");
        return user;
    }

}
