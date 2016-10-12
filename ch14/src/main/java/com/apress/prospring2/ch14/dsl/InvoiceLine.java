package com.apress.prospring2.ch14.dsl;

/**
 * @author janm
 */
public class InvoiceLine {
    private String sku;

    public InvoiceLine(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
