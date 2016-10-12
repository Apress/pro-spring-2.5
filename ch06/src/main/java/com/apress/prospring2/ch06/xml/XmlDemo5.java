package com.apress.prospring2.ch06.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.apress.prospring2.ch06.services.UserService;
import com.apress.prospring2.ch06.services.StockService;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author janm
 */
public class XmlDemo5 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/xmldemo5-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        StockService stockService = (StockService) ac.getBean("stockService");

        userService.login("janm");
        stockService.getStockLevel("A");
        stockService.applyDiscounts(new Date(), BigDecimal.ONE);
    }

}