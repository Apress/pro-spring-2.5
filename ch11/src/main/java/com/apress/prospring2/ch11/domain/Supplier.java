package com.apress.prospring2.ch11.domain;

/**
 * @author janm
 */
public class Supplier extends AbstractIdentityVersionedObject<Long> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
