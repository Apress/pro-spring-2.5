package com.apress.prospring2.ch06.introductions;

import com.apress.prospring2.ch06.services.StockService;
import com.apress.prospring2.ch06.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author janm
 */
public class IntroductionDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/introductionsdemo1-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        describeTracker(userService);
        userService.login("janm");
        userService.setAdministratorUsername("x");
        describeTracker(userService);

        StockService stockService = (StockService) ac.getBean("stockService");
        describeTracker(stockService);
        try {
            stockService.getStockLevel(null);
        } catch (Exception ignored) {
        
        }
        System.out.println(stockService.getStockLevel("ABC"));
        stockService.applyDiscounts(new Date(), new BigDecimal("10.0"));
        describeTracker(stockService);
    }

    private static void describeTracker(Object o) {
        CallTracker t = (CallTracker)o;
        System.out.println(t.describe());
    }

}
