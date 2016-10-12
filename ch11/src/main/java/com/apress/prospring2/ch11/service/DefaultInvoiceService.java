package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.dataaccess.InvoiceDao;
import com.apress.prospring2.ch11.domain.Invoice;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author janm
 */
public class DefaultInvoiceService implements InvoiceService {
    private InvoiceDao invoiceDao;

    public List<Invoice> search(int firstResult, int pageSize) {
        return this.invoiceDao.search(firstResult, pageSize);
    }

    public Invoice findById(Long id) {
        return this.invoiceDao.getById(id);
    }

    public void recalculateDiscounts(Long id) {
        Invoice invoice = this.invoiceDao.getByIdLazy(id);
        BigDecimal total = invoice.getLinesTotalPrice();
        if (total.compareTo(BigDecimal.TEN) > 0) {
            // do something special
        }
    }

    public void save(Invoice invoice) {
        this.invoiceDao.save(invoice);
    }

    public List<Invoice> findAll() {
        return this.invoiceDao.getAll();
    }

    public void setInvoiceDao(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }
}
