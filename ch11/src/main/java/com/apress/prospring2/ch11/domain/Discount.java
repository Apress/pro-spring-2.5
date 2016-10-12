package com.apress.prospring2.ch11.domain;

import java.math.BigDecimal;

/**
 * @author janm
 */
public class Discount extends AbstractIdentityVersionedObject<Long> {
    private InvoiceLine invoiceLine;
    private String type;
    private BigDecimal amount;

    public InvoiceLine getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
