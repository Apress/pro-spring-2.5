package com.apress.prospring2.ch22.dao;

import com.apress.prospring2.ch22.domain.Invoice;

import java.util.List;

/**
 * @author janm
 */
public interface BatchInvoiceDao {

    void insertAll(List<Invoice> invoices);
}
