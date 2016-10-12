package com.apress.prospring2.ch06.simple;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author janm
 */
public final class SystemPointcuts {

    private SystemPointcuts() {
        
    }

    @Pointcut("execution(* com.apress.prospring2.ch06..*.*(..)) &&" +
            "!execution(* com.apress.prospring2.ch06..*.set*(..)) &&" +
            "!execution(* com.apress.prospring2.ch06..*.get*())")
    public void serviceExecution() { }

    @Pointcut("within(com..TestBean2)")
    public void within1() { }

    @Pointcut("execution(* com.apress.prospring2.ch06.simple.TestBean2.*(..))")
    public void testBeanExecution() { }

    @Pointcut("execution(* com.apress.prospring2.ch06.simple.TestBean2.*(..))")
    private void testBeanExec() { }

    @Pointcut("execution(* com.apress.prospring2.ch06..*.*(..))")
    public void inProsringPackage() { }

    @Pointcut("within(com.apress.prospring2..*)")
    private void withinProSpringPackage() { }

    @Pointcut("execution(* com.apress.prospring2.ch06.simple.TestBean2.*(..)) &&" +
            "within(com.apress.prospring2..*)")
    public void same1() { }

    @Pointcut("execution(* com.apress.prospring2.ch06.simple.TestBean2.*(..)) &&" +
            "withinProSpringPackage()")
    public void same2() { }

    @Pointcut("testBeanExec() && withinProSpringPackage()")
    public void same3() { }


    @Pointcut("within(com.apress.prospring2.ch06.simple.TestBean2)")
    public void fromTestBeanExecution() { }

    @Pointcut("this(SimpleBean)")
    public void onlyFromSimpleBean() { }

    @Pointcut("target(SimpleBean)")
    public void onlyToSimpleBean() { }

    @Pointcut("args(String, String)")
    public void onlyTwoStringArguments() { }

//    @Pointcut("bean(test)")
    public void beanName() { }
}
