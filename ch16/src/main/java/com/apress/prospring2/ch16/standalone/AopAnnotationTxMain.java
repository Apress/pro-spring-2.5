package com.apress.prospring2.ch16.standalone;

import com.apress.prospring2.ch16.services.BankService;
import com.apress.prospring2.ch16.domain.AccountIdentity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author janm
 */
public class AopAnnotationTxMain {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[] {
                        "/META-INF/spring/*-context.xml",
                        "/META-INF/spring/*-context-aopann.xml"
                }
        );
        BankService bankService = (BankService) ac.getBean("bankService");
        final AccountIdentity a1 = new AccountIdentity("011001", "12345678");
        final AccountIdentity a2 = new AccountIdentity("011001", "10203040");

        System.out.println("Before");
        System.out.println(a1 + ": " + bankService.getBalance(a1));
        System.out.println(a2 + ": " + bankService.getBalance(a2));
        try {
            bankService.transfer(a1, a2, new BigDecimal("200.00"));
        } catch (Exception ignored) {

        }
        System.out.println("After");
        System.out.println(a1 + ": " + bankService.getBalance(a1));
        System.out.println(a2 + ": " + bankService.getBalance(a2));
    }

}