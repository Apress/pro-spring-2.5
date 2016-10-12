package com.apress.prospring2.ch22.domain;

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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Supplier");
        sb.append("{name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}