package com.apress.prospring2.ch20.methodnamebased;

/**
 * @author anirvanc
 */
public class SpringBean {
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

    public String anotherExposedMethod() {
        return "This is another method which is exposed.";
    }

    public void notExposedMethod() {
        throw new RuntimeException();
    }
}
