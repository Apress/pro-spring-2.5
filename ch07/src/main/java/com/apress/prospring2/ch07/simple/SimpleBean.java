package com.apress.prospring2.ch07.simple;

/**
 * @author janm
 */
public class SimpleBean {
    private String name;
    private String value;

    public SimpleBean() {
        this.name = "Name";
        this.value = "Anirvan Chakraborty";
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
