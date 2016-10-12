package com.apress.prospring2.ch11.domain;

import java.math.BigDecimal;
import java.util.Set;
import java.util.HashSet;

/**
 * @author janm
 */
public class InvoiceLine extends AbstractIdentityVersionedObject<Long> {
    private Invoice invoice;
    private String productCode;
    private BigDecimal price;
    private BigDecimal vat;
    private Set<Discount> discounts = new HashSet<Discount>();

    public void addDiscount(Discount discount) {
        discount.setInvoiceLine(this);
        this.discounts.add(discount);
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public Set<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Set<Discount> discounts) {
        this.discounts = discounts;
    }
}
