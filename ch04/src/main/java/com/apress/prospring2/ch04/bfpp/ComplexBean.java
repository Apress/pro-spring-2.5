package com.apress.prospring2.ch04.bfpp;

/**
 * @author janm
 */
@Magic
public class ComplexBean {
    private String name;
    protected SimpleBean simpleBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ComplexBean");
        sb.append("{name='").append(name).append('\'');
        sb.append(", simpleBean=").append(simpleBean);
        sb.append('}');
        return sb.toString();
    }
}
