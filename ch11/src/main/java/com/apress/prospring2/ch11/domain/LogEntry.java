package com.apress.prospring2.ch11.domain;

import java.util.Date;

/**
 * @author janm
 */
public class LogEntry extends AbstractIdentityVersionedObject<Long> {
    private String name;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
