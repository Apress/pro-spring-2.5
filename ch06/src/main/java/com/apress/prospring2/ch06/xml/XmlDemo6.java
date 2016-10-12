package com.apress.prospring2.ch06.xml;

import com.apress.prospring2.ch06.introductions.CallTracker;
import com.apress.prospring2.ch06.services.StockService;
import com.apress.prospring2.ch06.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author janm
 */
public class XmlDemo6 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/xmldemo6-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        StockService stockService = (StockService) ac.getBean("stockService");

        userService.login("janm");
        stockService.getStockLevel("A");
        stockService.applyDiscounts(new Date(), BigDecimal.ONE);

        describeTracker(userService);
        describeTracker(stockService);
    }

    private static void describeTracker(Object o) {
        CallTracker t = (CallTracker)o;
        System.out.println(t.describe());
    }

}