package com.apress.prospring2.ch22.dao.hibernate;

import com.apress.prospring2.ch22.dao.InvoiceDao;
import com.apress.prospring2.ch22.domain.Invoice;
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

    public Invoice getById(Long id) {
        return (Invoice) DataAccessUtils.uniqueResult(
                getHibernateTemplate().find(
                        "from Invoice i inner join fetch i.supplier " +
                                "inner join fetch i.lines il " +
                                "inner join fetch il.discounts " +
                                "where i.id=?", id));
    }

    @SuppressWarnings({"unchecked"})
    public List<Invoice> getBySupplierName(
            final String name, final int firstResult, final int maxResults) {
        return (List<Invoice>)
                getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery(
                        "from Invoice where supplier.name like :name");
                query.setString("name", name);
                query.setFirstResult(firstResult);
                query.setMaxResults(maxResults);

                return query.list();
            }
        });
    }


}