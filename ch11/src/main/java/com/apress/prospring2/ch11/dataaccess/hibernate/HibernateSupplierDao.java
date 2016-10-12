package com.apress.prospring2.ch11.dataaccess.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.apress.prospring2.ch11.dataaccess.SupplierDao;
import com.apress.prospring2.ch11.domain.Supplier;

/**
 * @author janm
 */
public class HibernateSupplierDao extends HibernateDaoSupport implements SupplierDao {

    public void save(Supplier supplier) {
        getHibernateTemplate().saveOrUpdate(supplier);
    }

    public Supplier getById(Long id) {
        return (Supplier) getHibernateTemplate().get(Supplier.class, id);
    }
}
