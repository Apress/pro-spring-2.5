package com.apress.prospring2.ch22.service;

import com.apress.prospring2.ch22.dao.BatchInvoiceDao;
import com.apress.prospring2.ch22.dao.InvoiceDao;
import com.apress.prospring2.ch22.dao.SupplierDao;
import com.apress.prospring2.ch22.domain.Invoice;
import com.apress.prospring2.ch22.domain.InvoiceLine;
import com.apress.prospring2.ch22.domain.Supplier;
import org.springmodules.cache.annotations.Cacheable;
import org.springmodules.cache.annotations.CacheFlush;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;

/**
 * @author janm
 */
public class DefaultInvoiceService implements InvoiceService {
    private InvoiceDao invoiceDao;
    private SupplierDao supplierDao;
    private BatchInvoiceDao batchInvoiceDao;

    public List<Invoice> findBySupplierName(String name, int firstResult, int maxResults) {
        return this.invoiceDao.getBySupplierName(name, firstResult, maxResults);
    }

    @CacheFlush(modelId = "Invoice")
    public void save(Invoice invoice) {
        this.invoiceDao.save(invoice);
    }

    public void importInvoices() {
        Supplier supplier1 = this.supplierDao.getByName("Supplier 1");
        Supplier supplier2 = this.supplierDao.getByName("Supplier 2");
        Supplier supplier3 = this.supplierDao.getByName("Supplier 13");
        List<Invoice> invoices = new LinkedList<Invoice>();
        for (int i = 0; i < 100; i++) {
            importForSupplier(supplier1, invoices);
            importForSupplier(supplier2, invoices);
            importForSupplier(supplier3, invoices);
        }
        this.batchInvoiceDao.insertAll(invoices);
    }

    private void importForSupplier(Supplier supplier, List<Invoice> invoices) {
        Random random = new Random();
        Invoice invoice = new Invoice();
        invoice.setDeliveryDate(new Date());
        invoice.setInvoiceDate(new Date());
        invoice.setSupplier(supplier);
        for (int i = 0; i < random.nextInt(10); i++) {
            InvoiceLine il = new InvoiceLine();
            il.setPrice(new BigDecimal("10.00"));
            il.setVat(new BigDecimal("1.175"));
            il.setProductCode("Code");
            invoice.addInvoiceLine(il);
        }
        invoices.add(invoice);
    }

    @Cacheable(modelId = "Invoice")
    public Invoice findById(Long id) {
        return this.invoiceDao.getById(id);
    }

    public void setInvoiceDao(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public void setSupplierDao(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    public void setBatchInvoiceDao(BatchInvoiceDao batchInvoiceDao) {
        this.batchInvoiceDao = batchInvoiceDao;
    }
}