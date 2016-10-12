package com.apress.prospring2.ch10.domain;

import java.util.List;

/**
 * @author Aleksa Vukotic
 */
public class Order extends AbstractIdentityObject<Integer> {
    private int customer;
    private List<OrderLine> orderLines;


    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Order { id: ");
        sb.append(this.id);
        sb.append(", customer: ");
        sb.append(this.customer);
        sb.append(", orderines: ");
        sb.append("[");
        for (OrderLine ol : this.orderLines) {
            sb.append(ol);
            sb.append(",");
        }
        sb.append("]}");
        return sb.toString();
    }
}
