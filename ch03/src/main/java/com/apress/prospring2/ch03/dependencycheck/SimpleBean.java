package com.apress.prospring2.ch03.dependencycheck;

/**
 * @author janm
 */
public class SimpleBean {
    private int someInt;
    private SimpleBean nestedSimpleBean;

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public void setNestedSimpleBean(SimpleBean nestedSimpleBean) {
        this.nestedSimpleBean = nestedSimpleBean;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SimpleBean");
        sb.append("{someInt=").append(someInt);
        sb.append(", nestedSimpleBean=").append(nestedSimpleBean);
        sb.append('}');
        return sb.toString();
    }
}
