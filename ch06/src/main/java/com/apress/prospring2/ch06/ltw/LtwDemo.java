package com.apress.prospring2.ch06.ltw;

import com.apress.prospring2.ch06.services.StockService;
import com.apress.prospring2.ch06.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * @author janm
 */
public class LtwDemo {

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/ltwdemo1-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        userService.login("janm");

        StockService stockService = (StockService) ac.getBean("stockService");
        System.out.println(stockService.getStockLevel("ABC"));
    }

}
