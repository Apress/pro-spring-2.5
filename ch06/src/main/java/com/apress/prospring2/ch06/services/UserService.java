package com.apress.prospring2.ch06.services;

import com.apress.prospring2.ch06.common.User;

/**
 * @author janm
 */
public interface UserService {

    void login(String username);

    void setAdministratorUsername(String administratorUsername);

    User findById(long id);

}
