package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.dataaccess.SupplierDao;
import com.apress.prospring2.ch11.domain.Supplier;

/**
 * @author janm
 */
public class DefaultSupplierService implements SupplierService {
    private SupplierDao supplierDao;

    public void save(Supplier supplier) {
        this.supplierDao.save(supplier);
    }

    public Supplier findById(Long id) {
        return this.supplierDao.getById(id);
    }

    public void setSupplierDao(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }
}
