package com.apress.prospring2.ch22.service;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import com.apress.prospring2.ch22.domain.Invoice;

/**
 * @author janm
 */
@ContextConfiguration(locations = {
        "classpath*:/META-INF/spring/*-context.xml",
        "classpath*:/META-INF/spring/*-context-t.xml"})
public class DefaultInvoiceServiceIntegrationTest
        extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    InvoiceService invoiceService;

    @Test
    @Repeat(50)
    @Timed(millis = 2000)
    public void testFindById() {
        Invoice invoice = this.invoiceService.findById(13000L);
        System.out.println("done");
        assertThat(invoice, notNullValue());
        assertThat(invoice.getSupplier().getName(), equalTo("Supplier 30"));
        assertThat(invoice.getId(), equalTo(13000L));
        assertThat(invoice.getLines().size(), equalTo(5));
    }
}
