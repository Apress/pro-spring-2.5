package com.apress.prospring2.ch21.dataaccess;

import com.apress.prospring2.ch21.domain.User;

import java.util.List;

/**
 * @author aleksav
 */
public interface UserDao {

    void save(User user);

    void delete(User user);

    User getById(Long id);

    List<User> getAll();

    User getByUsername(String username);
}
