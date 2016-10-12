package com.apress.prospring2.ch11.dataaccess.hibernate;

import com.apress.prospring2.ch11.dataaccess.LobTestDao;
import com.apress.prospring2.ch11.domain.LobTest;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author janm
 */
public class HibernateLobTestDao extends HibernateDaoSupport implements LobTestDao {

    public void save(LobTest lobTest) {
        getHibernateTemplate().save(lobTest);
    }

    public LobTest getById(Long id) {
        return (LobTest) getHibernateTemplate().get(LobTest.class, id);
    }
}
