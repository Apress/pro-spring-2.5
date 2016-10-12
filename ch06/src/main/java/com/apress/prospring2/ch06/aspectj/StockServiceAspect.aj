package com.apress.prospring2.ch06.aspectj;

public aspect StockServiceAspect {
    private String suffix;
    private String prefix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    pointcut doServiceCall() :
        execution(* com.apress.prospring2.ch06.services.*.*(..));

    before() : doServiceCall() {
        System.out.println(this.prefix);
    }

    after() : doServiceCall() {
        System.out.println(this.suffix);
    }
}