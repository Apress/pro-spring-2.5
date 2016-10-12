package com.apress.prospring2.ch06.proxies;

import com.apress.prospring2.ch06.services.DefaultStockService;
import com.apress.prospring2.ch06.services.StockService;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import sun.awt.AppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class ProxyDemo5 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/proxydemo3-context.xml"
        );
        StockService stockService =
                (StockService)ac.getBean("stockService");

        stockService.getStockLevel("A");
    }

}