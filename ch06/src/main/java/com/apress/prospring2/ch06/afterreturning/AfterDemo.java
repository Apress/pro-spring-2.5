package com.apress.prospring2.ch06.afterreturning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.apress.prospring2.ch06.services.UserService;
import com.apress.prospring2.ch06.services.StockService;

/**
 * @author janm
 */
public class AfterDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/afterreturningdemo1-context.xml"
        );
        UserService userService = (UserService) ac.getBean("userService");
        userService.login("janm");

        System.out.println(userService.findById(100));
    }

}
