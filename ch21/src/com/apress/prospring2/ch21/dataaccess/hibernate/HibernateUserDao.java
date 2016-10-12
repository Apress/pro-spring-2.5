package com.apress.prospring2.ch21.dataaccess.hibernate;

import com.apress.prospring2.ch21.dataaccess.UserDao;
import com.apress.prospring2.ch21.dataaccess.exception.InvalidResultException;
import com.apress.prospring2.ch21.domain.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author aleksav
 */
public class HibernateUserDao extends HibernateDaoSupport implements UserDao {

    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

    public User getById(Long id) {
        return (User) getHibernateTemplate().get(User.class, id);
    }

    public List<User> getAll() {
        return getHibernateTemplate().find("from User");
    }

    public User getByUsername(String username) {
        List objects = getHibernateTemplate().find("from User where username = ?", username);
        if (objects.size() == 1) return (User) objects.get(0);
        if (objects.size() > 1) {
            throw new InvalidResultException("Found more than one results");
        }
        return null;
    }
}
