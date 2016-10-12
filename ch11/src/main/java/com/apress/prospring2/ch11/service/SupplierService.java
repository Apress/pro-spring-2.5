package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.domain.Supplier;

/**
 * @author janm
 */
public interface SupplierService {

    void save(Supplier supplier);

    Supplier findById(Long id);

}
