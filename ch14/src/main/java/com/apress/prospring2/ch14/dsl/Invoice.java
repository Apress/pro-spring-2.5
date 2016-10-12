package com.apress.prospring2.ch14.dsl;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/**
 * @author janm
 */
public class Invoice {
    private Date invoiceDate;
    private Date deliveryDate;
    private Set<InvoiceLine> lines = new HashSet<InvoiceLine>();
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Set<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(Set<InvoiceLine> lines) {
        this.lines = lines;
    }

    public void addLine(InvoiceLine line) {
        this.lines.add(line);
    }
}
