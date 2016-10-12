package com.apress.prospring2.ch16.domain;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author janm
 */
public final class AccountIdentity implements Serializable {
    private static final long serialVersionUID = 3287882727785753918L;
    private String sortCode;
    private String number;

    public AccountIdentity() {
    }

    public AccountIdentity(String sortCode, String number) {
        Assert.notNull(sortCode, "The 'sortCode' argument must not be null.");
        Assert.notNull(number, "The 'number' argument must not be null.");

        this.sortCode = sortCode;
        this.number = number;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AccountIdentity {");
        sb.append(this.sortCode, 0, 2);
        sb.append("-");
        sb.append(this.sortCode, 2, 4);
        sb.append("-");
        sb.append(this.sortCode, 4, 6);
        sb.append(" ");
        sb.append(this.number, 0, 4);
        sb.append("-");
        sb.append(this.number, 4, 8);
        sb.append("}");
        return sb.toString();
    }
}
