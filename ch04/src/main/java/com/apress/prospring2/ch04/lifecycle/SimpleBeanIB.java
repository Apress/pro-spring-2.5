package com.apress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author janm
 */
public class SimpleBeanIB implements InitializingBean {
    private static final String DEFAULT_NAME = "Jan Machacek";
    private String name;
    private int age = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SimpleBean");
        sb.append("{name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("initializing bean");
        if (this.name == null) {
            System.out.println("No name specified, using default.");
            this.name = DEFAULT_NAME;
        }
        if (this.age == 0) {
            throw new IllegalArgumentException("You must set the [age] property bean of type [" + getClass().getName() + "]");
        }
    }
}