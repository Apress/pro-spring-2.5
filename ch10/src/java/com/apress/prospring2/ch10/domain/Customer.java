package com.apress.prospring2.ch10.domain;

import java.util.Date;

/**
 * @author Aleksa Vukotic
 */
public class Customer extends AbstractIdentityObject<Long> {
    private String firstName;
    private String lastName;
    private Date lastLogin;

    private CustomerDetail customerDetail;
    private CustomerDetail customerGossip;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public CustomerDetail getCustomerGossip() {
        return customerGossip;
    }

    public void setCustomerGossip(CustomerDetail customerGossip) {
        this.customerGossip = customerGossip;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Customer { id: ");
        sb.append(this.id);
        sb.append(", firstName: ");
        sb.append(this.firstName);
        sb.append(", lastName: ");
        sb.append(this.lastName);
        sb.append(", lastLogin: ");
        sb.append(this.lastLogin);
        sb.append(", detail: ");
        sb.append(this.customerDetail);
        sb.append(", gossip: ");
        sb.append(this.customerGossip);
        sb.append("}");
        return sb.toString();
    }
}
