package com.apress.prospring2.ch22.domain;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Discount");
        sb.append("{type='").append(type).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}