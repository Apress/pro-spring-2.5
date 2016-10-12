package com.apress.prospring2.ch11.dataaccess.hibernate;

import com.apress.prospring2.ch11.dataaccess.LogEntryDao;
import com.apress.prospring2.ch11.domain.LogEntry;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author janm
 */
@Repository
public class TemplatelessHibernateInvoiceLogEntryDao implements LogEntryDao {
    private SessionFactory sessionFactory;

    public TemplatelessHibernateInvoiceLogEntryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LogEntry getById(Long id) {
        return (LogEntry) this.sessionFactory.getCurrentSession().get(LogEntry.class, id);
    }

    public LogEntry getByName(String name) {
        Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
        try {
            return (LogEntry) this.sessionFactory.getCurrentSession().createQuery("from LogEntry where name = :name").
                    setParameter("name", name).
                    uniqueResult();
        } finally {
            transaction.commit();
        }
    }

    public void save(LogEntry logEntry) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(logEntry);
    }

    public List<LogEntry> getAll() {
        Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
        try {
            return this.sessionFactory.getCurrentSession().createQuery("from LogEntry").list();
        } finally {
            transaction.commit();
        }
    }
}
