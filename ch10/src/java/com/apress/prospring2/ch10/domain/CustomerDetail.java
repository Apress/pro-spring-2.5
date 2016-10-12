package com.apress.prospring2.ch10.domain;

/**
 * @author Aleksa Vukotic
 */
public class CustomerDetail extends AbstractIdentityObject<Long> {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CustomerDetail { id: ");
        sb.append(this.id);
        sb.append(", date: ");
        sb.append(this.data);
        sb.append("}");
        return sb.toString();
    }
}
