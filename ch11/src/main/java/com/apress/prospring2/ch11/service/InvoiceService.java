package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.domain.Invoice;

import java.util.List;

/**
 * @author janm
 */
public interface InvoiceService {

    List<Invoice> search(int firstResult, int pageSize);

    Invoice findById(Long id);

    void recalculateDiscounts(Long id);

    void save(Invoice invoice);

    List<Invoice> findAll();

}
