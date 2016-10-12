package com.apress.prospring2.ch05.aspectj;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;


/**
 * Created by aleksav
 */
public class AspectJExpressionPointcutDemo {

    public static void main(String[] args) {
        SampleBean target = new SampleBean();

        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* com.apress.prospring2.ch05.aspectj..*.get*(..))");

        SampleBean proxy = getProxy(pc, target);
        proxy.getName();
        proxy.setName("New Name");
        proxy.getHeight();

    }

    private static SampleBean getProxy(AspectJExpressionPointcut pc, SampleBean target) {
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
