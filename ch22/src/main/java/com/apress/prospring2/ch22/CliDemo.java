package com.apress.prospring2.ch22;

import com.apress.prospring2.ch22.domain.Discount;
import com.apress.prospring2.ch22.domain.Invoice;
import com.apress.prospring2.ch22.domain.InvoiceLine;
import com.apress.prospring2.ch22.service.InvoiceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author janm
 */
public class CliDemo {
    private static final Pattern I_PATTERN = Pattern.compile("i\\W+(\\d+)");
    private static final Pattern S_PATTERN = Pattern.compile("s\\W+((\\d+)-(\\d+)\\W+)?(.+)");
    private static final Pattern ST_PATTERN = Pattern.compile("st\\W+(\\d+)");
    private InvoiceService invoiceService;
    private List<Invoice> allInvoices = new LinkedList<Invoice>();

    private void findById(String line) {
        Matcher matcher;
        matcher = I_PATTERN.matcher(line);
        if (!matcher.matches()) return;
        Invoice invoice =
                this.invoiceService.findById(Long.valueOf(matcher.group(1)));
        
        System.out.println("Supplier: " + invoice.getSupplier());
        System.out.println("Delivery Date: " + invoice.getDeliveryDate());
        System.out.println("Invoice Date: " + invoice.getInvoiceDate());
        for (InvoiceLine invoiceLine : invoice.getLines()) {
            System.out.println("* " + invoiceLine.getProductCode() + " @ " +
                    invoiceLine.getPrice() + " + " +
                    invoiceLine.getVat());
            for (Discount discount : invoiceLine.getDiscounts()) {
                System.out.println("    * - " + discount.getAmount());
            }
        }
    }

    private void findBySupplierName(String line) {
        Matcher matcher = S_PATTERN.matcher(line);
        if (!matcher.matches()) return;
        int firstResult = 0;
        int maxResults = Integer.MAX_VALUE;
        if (matcher.group(2) != null) {
            firstResult = Integer.valueOf(matcher.group(2));
        }
        if (matcher.group(3) != null) {
            maxResults = Integer.valueOf(matcher.group(3));
        }
        List<Invoice> invoices =
                this.invoiceService.findBySupplierName(matcher.group(4),
                        firstResult, maxResults);
        System.out.println(invoices);
    }

    private void importInvoices(String line) {
        if (!"im".equalsIgnoreCase(line)) return;
        this.invoiceService.importInvoices();
    }

    private void stressTest(String line) throws InterruptedException {
        Matcher matcher = ST_PATTERN.matcher(line);
        if (!matcher.matches()) return;
        int count = Integer.valueOf(matcher.group(1));
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            executorService.submit(new Stresser(this.invoiceService, this.allInvoices));
        }
    }

    public static void main(String[] args)
            throws IOException, InterruptedException {
        CliDemo me = new CliDemo();
        me.run();
    }

    private void run() throws IOException, InterruptedException {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/*-context.xml"
        );
        this.invoiceService = (InvoiceService) ac.getBean("invoiceService");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            String line = reader.readLine();
            findById(line);
            findBySupplierName(line);
            importInvoices(line);
            stressTest(line);
            
            if ("q".equals(line)) break;
        }
    }

    private static class Stresser implements Runnable {
        private InvoiceService invoiceService;
        private Random random;
        private int count;
        private List<Invoice> allInvoices;

        Stresser(InvoiceService invoiceService, List<Invoice> allInvoices) {
            this.invoiceService = invoiceService;
            this.random = new Random();
            this.count = this.random.nextInt(50);
            this.allInvoices = allInvoices;
        }

        public void run() {
            if (this.random.nextInt() % 3 == 0) {
                this.allInvoices.addAll(
                        this.invoiceService.findBySupplierName("%", 0, 20000)
                );
            }
            for (int i = 0; i < this.count; i++) {
                String supplierName = String.format("Supplier %d%%",
                        this.random.nextInt(50));
                List<Invoice> invoices = this.invoiceService.findBySupplierName(
                        supplierName,
                        this.random.nextInt(100),
                        this.random.nextInt(10000));
                this.allInvoices.addAll(invoices);
                this.invoiceService.findById((long)this.random.nextInt(50000));
            }
        }
    }

}
