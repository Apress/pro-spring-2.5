package com.apress.prospring2.ch06.around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.apress.prospring2.ch06.services.UserService;
import com.apress.prospring2.ch06.services.StockService;

/**
 * @author janm
 */
public class CachingDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/arounddemo1-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        userService.login("janm");

        StockService stockService = (StockService) ac.getBean("stockService");
        long start = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - start + ": " +
                stockService.getStockLevel("A"));
        System.out.println(System.currentTimeMillis() - start + ": " +
                stockService.getStockLevel("B"));
        System.out.println(System.currentTimeMillis() - start + ": " +
                stockService.getStockLevel("C"));
        System.out.println(System.currentTimeMillis() - start + ": " +
                stockService.getStockLevel("C"));
        System.out.println(System.currentTimeMillis() - start + ": " +
                stockService.getStockLevel("A"));
        System.out.println(System.currentTimeMillis() - start + ": " +
                stockService.getStockLevel("B"));
    }

}
