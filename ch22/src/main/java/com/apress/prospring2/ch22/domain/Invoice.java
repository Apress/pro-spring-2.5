package com.apress.prospring2.ch22.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author janm
 */
public class Invoice extends AbstractIdentityVersionedObject<Long> {
    private Date invoiceDate;
    private Date deliveryDate;
    private boolean disputed;
    private Supplier supplier;
    private Set<InvoiceLine> lines = new HashSet<InvoiceLine>();

    public void addInvoiceLine(InvoiceLine line) {
        line.setInvoice(this);
        this.lines.add(line);
    }

    public BigDecimal getLinesTotalPrice() {
        BigDecimal total = new BigDecimal(0);
        for (InvoiceLine line : this.lines) {
            total = total.add(line.getPrice());
        }
        return total;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isDisputed() {
        return disputed;
    }

    public void setDisputed(boolean disputed) {
        this.disputed = disputed;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(Set<InvoiceLine> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invoice");
        sb.append("{invoiceDate=").append(invoiceDate);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", disputed=").append(disputed);
        sb.append('}');
        return sb.toString();
    }
}