package com.apress.prospring2.ch21.services;

import com.apress.prospring2.ch21.dataaccess.UserDao;
import com.apress.prospring2.ch21.domain.User;

import java.util.List;

/**
 * @author aleksav
 */
public class DefaultUserService implements UserService {

    private UserDao userDao;

    public void register(User user) {
        if (this.userDao.getByUsername(user.getUsername()) != null)
            throw new IllegalArgumentException("Same username already exists!");
        if (user.getPassword().length() < 6)
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        this.userDao.save(user);
    }

    public List<User> findAllUsers() {
        return this.userDao.getAll();
    }

    public void delete(User user) {
        this.userDao.delete(user);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
