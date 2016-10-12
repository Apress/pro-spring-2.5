package com.apress.prospring2.ch11.dataaccess;

import com.apress.prospring2.ch11.domain.Supplier;

/**
 * @author janm
 */
public interface SupplierDao {

    void save(Supplier supplier);

    Supplier getById(Long id);    
}
