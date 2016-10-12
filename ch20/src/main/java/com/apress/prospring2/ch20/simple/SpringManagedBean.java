package com.apress.prospring2.ch20.simple;

/**
 * Author: anirvanc
 */
//public class SpringManagedBean implements ManagedInterface {
public class SpringManagedBean {
    private String property;
    private String anotherProperty;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getAnotherProperty() {
        return anotherProperty;
    }

    public void setAnotherProperty(String anotherProperty) {
        this.anotherProperty = anotherProperty;
    }

    public String exposedMethod() {
        return "This method is exposed.";
    }

    public void notExposedMethod() {
        throw new RuntimeException();
    }
}
