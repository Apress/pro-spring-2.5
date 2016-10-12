package com.apress.prospring2.ch06.lifecycle;

import com.apress.prospring2.ch06.services.UserService;
import com.apress.prospring2.ch06.services.StockService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class LifecycleDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/lifecycledemo1-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        StockService stockService = (StockService) ac.getBean("stockService");

        for (int i = 0; i < 2; i++) {
            userService.login("janm");
        }
        stockService.getStockLevel("A");
    }

}
