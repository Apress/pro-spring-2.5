package com.apress.prospring2.ch06.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.apress.prospring2.ch06.services.UserService;
import com.apress.prospring2.ch06.services.StockService;

/**
 * @author janm
 */
public class AspectJDemo1 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/aspectjdemo1-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        userService.login("janm");

        StockService stockService = (StockService) ac.getBean("stockService");
        System.out.println(stockService.getStockLevel("ABC"));
    }

}
