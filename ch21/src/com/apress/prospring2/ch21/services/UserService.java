package com.apress.prospring2.ch21.services;

import com.apress.prospring2.ch21.domain.User;

import java.util.List;

/**
 * @author aleksav
 */
public interface UserService {

    void register(User user);

    List<User> findAllUsers();

    void delete(User user);
}
