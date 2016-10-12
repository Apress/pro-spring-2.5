package com.apress.prospring2.ch21.services;

import com.apress.prospring2.ch11.domain.Invoice;
import com.apress.prospring2.ch11.domain.Supplier;
import com.apress.prospring2.ch11.service.InvoiceService;
import com.apress.prospring2.ch11.service.SupplierService;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.annotation.AbstractAnnotationAwareTransactionalTests;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.Repeat;

import javax.naming.NamingException;
import java.util.Date;

/**
 * @author aleksav
 */
public class DefaultInvoiceServiceIntegrationTests extends AbstractAnnotationAwareTransactionalTests {
//    private ApplicationContext getApplicationContext(){
//        String [] paths = new String[] {
//                "classpath*:/com/apress/prospring2/ch11/dataaccess/datasource-context-tx.xml",
//                "classpath*:/com/apress/prospring2/ch11/service/*-context.xml"
//        };
//        return new ClassPathXmlApplicationContext(paths);
//    }

    protected String[] getConfigLocations() {
        buildJndi();
        String[] paths = new String[]{
                "classpath*:/com/apress/prospring2/ch11/dataaccess/datasource-context-tx.xml",
                "classpath*:/com/apress/prospring2/ch11/service/*-context.xml"
        };
        return paths;
    }


    public static void buildJndi() {
        try {
            SimpleNamingContextBuilder builder;
            builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();

            String connectionString = "jdbc:oracle:thin:@oracle.devcake.co.uk:1521:INTL";
            builder.bind("java:comp/env/jdbc/prospring2/ch11", new DriverManagerDataSource(
                    "oracle.jdbc.driver.OracleDriver", connectionString, "PROSPRING", "x******6"));
        } catch (NamingException e) {
            // noop
        }
    }

    @IfProfileValue(name = "java.vendor", value = "fdfdfSun Microsystems Inc.")
    @Repeat(10)
    public void testRecalculateDiscounts() {
//        buildJndi();
        ApplicationContext context = getApplicationContext();
        InvoiceService invoiceService = (InvoiceService) context.getBean("invoiceService");
        SupplierService supplierService = (SupplierService) context.getBean("supplierService");
        Supplier supplier = new Supplier();
        supplier.setName("test supplier");
        supplierService.save(supplier);
        Invoice invoice = new Invoice();
        invoice.setDisputed(true);
        invoice.setDeliveryDate(new Date());
        invoice.setInvoiceDate(new Date());
        invoice.setSupplier(supplier);
        invoiceService.save(invoice);

        invoiceService.recalculateDiscounts(invoice.getId());


        assertNotNull(invoice);
        System.out.println("test run");


    }

    @ExpectedException(java.lang.NullPointerException.class)
    public void testException() {
        throw new NullPointerException("testpasses");

    }
}
