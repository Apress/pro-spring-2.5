package com.apress.prospring2.ch05.annotation;


import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import com.apress.prospring2.ch05.aspectj.SimpleAfterAdvice;


/**
 * Created by aleksav
 */
public class AnnotationMatchingPointcutDemo {

    public static void main(String[] args) {
        SampleBean target = new SampleBean();

        AnnotationMatchingPointcut pc = new AnnotationMatchingPointcut(null, SimpleAnnotation.class);

        SampleBean proxy = getProxy(pc, target);

        proxy.getName();

        proxy.getHeight();
    }

    private static SampleBean getProxy(AnnotationMatchingPointcut pc, SampleBean target) {
        // create the advisor

        Advisor advisor = new DefaultPointcutAdvisor(pc,
                new SimpleAfterAdvice());

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        return (SampleBean) pf.getProxy();
    }
}
