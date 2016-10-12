package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.domain.Invoice;
import com.apress.prospring2.ch11.util.DaoDemoUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author janm
 */
public class InvoiceServiceDemo {
    private SupplierService supplierService;
    private InvoiceService invoiceService;

    private void run() throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
            "classpath*:/com/apress/prospring2/ch11/dataaccess/datasource-context-tx.xml",
            "classpath*:/com/apress/prospring2/ch11/service/*-context.xml"
        });
        this.invoiceService = (InvoiceService)ac.getBean("invoiceService");
        this.supplierService = (SupplierService)ac.getBean("supplierService");

        this.invoiceService.recalculateDiscounts(10005L);
        //findOneInvoice();
        //findAllInvoices();
    }

    private void findOneInvoice() {
        Invoice invoice = this.invoiceService.findById(10005L);
        System.out.println(invoice);
    }

    private void findAllInvoices() {
        List<Invoice> invoices = this.invoiceService.findAll();
        System.out.println(invoices.size());
    }

    public static void main(String[] args) throws Exception {
        new InvoiceServiceDemo().run();
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
    
}
