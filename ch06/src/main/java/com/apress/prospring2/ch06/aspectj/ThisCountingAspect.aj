package com.apress.prospring2.ch06.aspectj;

public aspect ThisCountingAspect perthis(doServiceCall()) {
    private int count;

    public String getMessage() {
        return " executed ";
    }

    pointcut doServiceCall() :
        execution(* com.apress.prospring2.ch06.services.*.*(..));

    before() : doServiceCall() {
        this.count++;
        System.out.println("Before call");
    }

    after(Object target) : doServiceCall() && this(target) {
        System.out.println(target + getMessage() + this.count + " times");
    }
}