package com.apress.prospring2.ch20.metadatabased;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;

/**
 * @author anirvanc
 */

@ManagedResource(objectName = "bean:name=metadataBasedMBean", description = "Meta-data based MBean.")
public class SpringBean {

    private String property;
    private String anotherProperty;

    @ManagedOperation(description = "This is a managed operation.")
    public String exposedMethod() {
        return "This method is exposed.";
    }

    @ManagedOperation(description = "This is another managed operation.")
    public String anotherExposedMethod() {
        return "This is another method which is exposed.";
    }

    public void notExposedMethod() {
        throw new RuntimeException();
    }

    @ManagedAttribute(description = "An attribute.")
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getAnotherProperty() {
        return anotherProperty;
    }

    @ManagedAttribute(description = "Another attribute.")
    public void setAnotherProperty(String anotherProperty) {
        this.anotherProperty = anotherProperty;
    }
}
