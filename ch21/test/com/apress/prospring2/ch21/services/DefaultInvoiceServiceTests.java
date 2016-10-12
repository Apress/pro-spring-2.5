package com.apress.prospring2.ch21.services;

import com.apress.prospring2.ch11.dataaccess.InvoiceDao;
import com.apress.prospring2.ch11.domain.Invoice;
import com.apress.prospring2.ch11.service.DefaultInvoiceService;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

/**
 * @author aleksav
 */
public class DefaultInvoiceServiceTests extends MockObjectTestCase {
    private Mock invoiceDao;
    private DefaultInvoiceService invoiceService;

    protected void setUp() throws Exception {
        this.invoiceDao = new Mock(InvoiceDao.class);
        invoiceService = new DefaultInvoiceService();
        invoiceService.setInvoiceDao((InvoiceDao)this.invoiceDao.proxy());
    }

    public void testFindById(){
        Invoice expectedResult = new Invoice();
        expectedResult.setId(1L);
        expectedResult.setDisputed(true);
        Long id = 1L;
        this.invoiceDao.expects(once()).method("getById").with(eq(id)).will(returnValue(expectedResult));

        Invoice invoice = this.invoiceService.findById(1L);

        assertNotNull("Invoice must not be null", invoice);
        assertEquals("Invoice id does no match!", 1L, invoice.getId().longValue());
    }
}
