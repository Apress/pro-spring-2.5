package com.apress.prospring2.ch14.dsl;

import com.apress.prospring2.ch14.dynamic.DynamicDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author janm
 */
public class DslDemo {

    public static void main(String[] args) throws IOException {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("dsl-context.xml", DslDemo.class);
        DiscountCalculator dc = (DiscountCalculator)ac.getBean("discountCalculator");
        Invoice invoice = new Invoice();
        invoice.addLine(new InvoiceLine("a"));
        invoice.addLine(new InvoiceLine("b"));
        invoice.addLine(new InvoiceLine("c"));
        System.out.println(dc.calculate(invoice));
    }
}
