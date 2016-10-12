package com.apress.prospring2.ch22.dao.jdbc;

import com.apress.prospring2.ch22.dao.BatchInvoiceDao;
import com.apress.prospring2.ch22.domain.Invoice;
import com.apress.prospring2.ch22.domain.InvoiceLine;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author janm
 */
public class JdbcBatchInvoiceDao extends JdbcDaoSupport
        implements BatchInvoiceDao {

    private static class SequenceNextvalSelect extends MappingSqlQuery {

        private SequenceNextvalSelect(DataSource ds) {
            super(ds, "select s_invoice_id.nextval from dual");
        }

        protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getLong(1);
        }
    }

    private static class InsertInvoicePreparedStatementCreator
            implements PreparedStatementCreator {

        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            return con.prepareStatement(
                    "insert into t_invoice " +
                            " (id, version, invoice_date, delivery_date, supplier) " +
                            "values (?, ?, ?, ?, ?)");
        }
    }

    private static class InsertInvoiceLinePreparedStatementCreator
            implements PreparedStatementCreator {

        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            return con.prepareStatement(
                    "insert into t_invoice_line " +
                            "(id, version, invoice, price, vat, product_code)" +
                            " values (s_invoice_line_id.nextval, " +
                            "?, ?, ?, ?, ?)");
        }
    }

    private static class InsertInvoicePreparedStatementSetter
            implements PreparedStatementSetter {
        private Invoice invoice;

        private InsertInvoicePreparedStatementSetter(Invoice invoice) {
            Assert.notNull(invoice, "The 'invoice' argument must not be null.");
            this.invoice = invoice;
        }

        private void setDate(PreparedStatement ps, int index, Date date)
                throws SQLException {
            ps.setDate(index, new java.sql.Date(date.getTime()));
        }

        public void setValues(PreparedStatement ps) throws SQLException {
            ps.setLong(1, this.invoice.getId());
            ps.setLong(2, 1L);
            setDate(ps, 3, this.invoice.getInvoiceDate());
            setDate(ps, 4, this.invoice.getDeliveryDate());
            ps.setLong(5, this.invoice.getSupplier().getId());
        }
    }

    private static class InsertInvoiceLinePreparedStatementSetter
            implements PreparedStatementSetter {
        private InvoiceLine invoiceLine;

        private InsertInvoiceLinePreparedStatementSetter(InvoiceLine invoiceLine) {
            this.invoiceLine = invoiceLine;
        }

        public void setValues(PreparedStatement ps) throws SQLException {
            ps.setLong(1, 1L);
            ps.setLong(2, this.invoiceLine.getInvoice().getId());
            ps.setBigDecimal(3, this.invoiceLine.getPrice());
            ps.setBigDecimal(4, this.invoiceLine.getVat());
            ps.setString(5, this.invoiceLine.getProductCode());
        }
    }

    private InsertInvoicePreparedStatementCreator
            insertInvoicePreparedStatementCreator;
    private InsertInvoiceLinePreparedStatementCreator
            insertInvoiceLinePreparedStatementCreator;

    public JdbcBatchInvoiceDao() {
        this.insertInvoicePreparedStatementCreator =
                new InsertInvoicePreparedStatementCreator();
        this.insertInvoiceLinePreparedStatementCreator =
                new InsertInvoiceLinePreparedStatementCreator();
    }


    public void insertAll(final List<Invoice> invoices) {
        getJdbcTemplate().execute(new ConnectionCallback() {
            public Object doInConnection(Connection con) throws SQLException, DataAccessException {
                PreparedStatement insInv =
                        insertInvoicePreparedStatementCreator.
                                createPreparedStatement(con);
                PreparedStatement insInvLine =
                        insertInvoiceLinePreparedStatementCreator.
                                createPreparedStatement(con);
                SequenceNextvalSelect snvs =
                        new SequenceNextvalSelect(getDataSource());

                for (Invoice invoice : invoices) {
                    invoice.setId((Long)snvs.findObject(new Object[]{}));
                    new InsertInvoicePreparedStatementSetter(invoice).
                            setValues(insInv);
                    insInv.addBatch();
                }

                insInv.executeBatch();

                for (Invoice invoice : invoices) {
                    for (InvoiceLine line : invoice.getLines()) {
                        new InsertInvoiceLinePreparedStatementSetter(line).
                                setValues(insInvLine);
                        insInvLine.addBatch();
                    }
                }
                insInvLine.executeBatch();
                return null;
            }
        });
    }
}
