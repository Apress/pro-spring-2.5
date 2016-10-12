package com.apress.prospring2.ch11.dataaccess;

import com.apress.prospring2.ch11.domain.Invoice;

import java.util.List;

/**
 * @author janm
 */
public interface InvoiceDao {

    void save(Invoice invoice);

    List<Invoice> getAll();

    Invoice getById(Long id);

    Invoice getByIdLazy(Long id);

    List<Invoice> search(int firstResult, int pageSize);

}
