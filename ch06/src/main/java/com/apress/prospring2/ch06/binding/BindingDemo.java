package com.apress.prospring2.ch06.binding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.apress.prospring2.ch06.services.UserService;
import com.apress.prospring2.ch06.services.StockService;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author janm
 */
public class BindingDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/bindingdemo1-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        userService.login("janm");

        StockService stockService = (StockService) ac.getBean("stockService");
        System.out.println(stockService.getStockLevel("ABC"));
        stockService.applyDiscounts(new Date(), new BigDecimal("10.0"));
    }
}
