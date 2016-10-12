package com.apress.prospring2.ch05.cflow;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * @author janm
 */
public class ComposablePointcutDemo {
    
    public static void main(String[] args) {
        // create target
        SampleBean target = new SampleBean();


        ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE,
                new GetterMethodMatcher());

        System.out.println("Test 1");
        SampleBean proxy = getProxy(pc, target);
        testInvoke(proxy);

        System.out.println("Test 2");
        pc.union(new SetterMethodMatcher());
        proxy = getProxy(pc, target);
        testInvoke(proxy);

        System.out.println("Test 3");
        pc.intersection(new GetAgeMethodMatcher());
        proxy = getProxy(pc, target);
        testInvoke(proxy);

    }

    private static SampleBean getProxy(ComposablePointcut pc, SampleBean target) {
        // create the advisor

        Advisor advisor = new DefaultPointcutAdvisor(pc,
                new SimpleBeforeAdvice());

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        return (SampleBean) pf.getProxy();
    }

    private static void testInvoke(SampleBean proxy) {
        proxy.getAge();
        proxy.getName();
        proxy.setName("Rob Harrop");
    }

    private static class GetterMethodMatcher extends StaticMethodMatcher {

        public boolean matches(Method method, Class cls) {
            return (method.getName().startsWith("get"));
        }

    }

    private static class GetAgeMethodMatcher extends StaticMethodMatcher {
        public boolean matches(Method method, Class cls) {
            return "getAge".equals(method.getName());
        }
    }

    private static class SetterMethodMatcher extends StaticMethodMatcher {

        public boolean matches(Method method, Class cls) {
            return (method.getName().startsWith("set"));
        }

    }
}
