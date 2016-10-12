package com.apress.prospring2.ch22.dao;

import com.apress.prospring2.ch22.domain.Supplier;

/**
 * @author janm
 */
public interface SupplierDao {

    Supplier getByName(String name);

}
