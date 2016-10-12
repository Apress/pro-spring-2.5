package com.apress.prospring2.ch06.proxies;

import com.apress.prospring2.ch06.services.DefaultStockService;
import com.apress.prospring2.ch06.services.StockService;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author janm
 */
public class ProxyDemo2 {

    private static class DelegatingInvocationHandler
        implements InvocationHandler {
        private Object target;

        private DelegatingInvocationHandler(Object target) {
            this.target = target;
        }

        public Object invoke(Object target,
                             Method method,
                             Object[] args) throws Throwable {
            return method.invoke(this.target, args);
        }
    }

    public static void main(String[] args) {
        DefaultStockService targetReference = new DefaultStockService();
        StockService proxyReference =
                (StockService) Proxy.newProxyInstance(
                        ProxyDemo2.class.getClassLoader(),
                        new Class<?>[] {StockService.class},
                        new DelegatingInvocationHandler(
                                targetReference
                        ));
        System.out.println("targetReference = " + targetReference);
        proxyReference.getStockLevel("X");
    }

}