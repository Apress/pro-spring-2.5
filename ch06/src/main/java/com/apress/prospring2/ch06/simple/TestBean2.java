package com.apress.prospring2.ch06.simple;

/**
 * @author janm
 */
public class TestBean2 {
    private SimpleBean simpleBean;

    public void work() {
        this.simpleBean.sayHello();
        System.out.println("work");
    }

    public void stop() {
        this.simpleBean.sayHello();
        System.out.println("stop");
    }

    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}