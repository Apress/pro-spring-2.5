package com.apress.prospring2.ch22.dao;

import com.apress.prospring2.ch22.domain.Invoice;

import java.util.List;

/**
 * @author janm
 */
public interface InvoiceDao {

    void save(Invoice invoice);

    Invoice getById(Long id);

    List<Invoice> getBySupplierName(String name, int firstResult, int maxResults);
}
