package com.apress.prospring2.ch22.dao.hibernate;

import com.apress.prospring2.ch22.dao.SupplierDao;
import com.apress.prospring2.ch22.domain.Supplier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.dao.support.DataAccessUtils;

/**
 * @author janm
 */
public class HibernateSupplierDao extends HibernateDaoSupport
        implements SupplierDao {

    public Supplier getByName(String name) {
        return (Supplier) DataAccessUtils.uniqueResult(
                getHibernateTemplate().find("from Supplier where name=?", name));
    }
}
