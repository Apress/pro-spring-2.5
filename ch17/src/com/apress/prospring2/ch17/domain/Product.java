package com.apress.prospring2.ch17.domain;

import java.util.Date;

/**
 * @author Aleksa Vukotic
 */
public class Product extends AbstractIdentityObject<Long> {
    private String name;
    private Date expirationDate;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public void setType(String type) {
        this.type = type;
    }public String getType() {
    return type;
}
}
