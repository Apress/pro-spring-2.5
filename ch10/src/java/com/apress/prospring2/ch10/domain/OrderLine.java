package com.apress.prospring2.ch10.domain;

import java.math.BigDecimal;

/**
 * @author Aleksa Vukotic
 */
public class OrderLine extends AbstractIdentityObject<Integer> {
    private int order;
    private String product;
    private BigDecimal price;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OrderLine { id: ");
        sb.append(this.id);
        sb.append(", order: ");
        sb.append(this.order);
        sb.append(", product: ");
        sb.append(this.product);
        sb.append("}");
        return sb.toString();
    }
}
