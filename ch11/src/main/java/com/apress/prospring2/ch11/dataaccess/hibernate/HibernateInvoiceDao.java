package com.apress.prospring2.ch11.dataaccess.hibernate;

import com.apress.prospring2.ch11.dataaccess.InvoiceDao;
import com.apress.prospring2.ch11.domain.Invoice;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * @author janm
 */
public class HibernateInvoiceDao extends HibernateDaoSupport implements InvoiceDao {

    public void save(Invoice invoice) {
        getHibernateTemplate().saveOrUpdate(invoice);
    }

    @SuppressWarnings({"unchecked"})
    public List<Invoice> getAll() {
        return getHibernateTemplate().find("from Invoice");
    }

    public Invoice getById(Long id) {
        return (Invoice) DataAccessUtils.uniqueResult(
                getHibernateTemplate().find("from Invoice i inner join fetch i.supplier " +
                        "inner join fetch i.lines il " +
                        "left outer join fetch il.discounts where i.id = ?", id)
        );
    }

    public Invoice getByIdLazy(Long id) {
        return (Invoice) getHibernateTemplate().get(Invoice.class, id);
    }

    @SuppressWarnings({"unchecked"})
    public List<Invoice> search(final int firstResult, final int pageSize) {
        return (List<Invoice>) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("from Invoice");
                query.setFirstResult(firstResult);
                query.setMaxResults(pageSize);
                return query.list();
            }
        });
    }
}
