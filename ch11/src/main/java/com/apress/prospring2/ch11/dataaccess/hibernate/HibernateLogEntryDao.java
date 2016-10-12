package com.apress.prospring2.ch11.dataaccess.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import com.apress.prospring2.ch11.dataaccess.LogEntryDao;
import com.apress.prospring2.ch11.domain.LogEntry;

import java.util.List;
import java.sql.SQLException;

/**
 * @author janm
 */
public class HibernateLogEntryDao extends HibernateDaoSupport implements LogEntryDao {

    public LogEntry getById(Long id) {
        return (LogEntry) getHibernateTemplate().get(LogEntry.class, id);
    }

    public LogEntry getByName(final String name) {
        return (LogEntry) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return session.createQuery("from LogEntry where name = :name").
                        setParameter("name", name).
                        uniqueResult();
            }
        });
    }

    public void save(LogEntry logEntry) {
        getHibernateTemplate().saveOrUpdate(logEntry);
    }
 
    @SuppressWarnings({"unchecked"})
    public List<LogEntry> getAll() {
        return getHibernateTemplate().find("from LogEntry");
    }
}
