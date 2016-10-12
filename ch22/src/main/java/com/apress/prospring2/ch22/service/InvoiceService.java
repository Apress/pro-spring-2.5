package com.apress.prospring2.ch22.service;


import com.apress.prospring2.ch22.domain.Invoice;

import java.util.List;

/**
 * @author janm
 */
public interface InvoiceService {

    List<Invoice> findBySupplierName(String name, int firstResult, int maxResults);

    void save(Invoice invoice);

    void importInvoices();

    Invoice findById(Long id);

}