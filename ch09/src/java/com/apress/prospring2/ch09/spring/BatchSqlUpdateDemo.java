package com.apress.prospring2.ch09.spring;

import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author janm
 */
class BatchSqlUpdateDemo {
    private BatchInsert batchInsert;

    private static class BatchInsert extends BatchSqlUpdate {
        private static final String SQL = "insert into t_customer (id, first_name, last_name, last_login, " +
                "comments) values (?, ?, ?, ?, null)";

        BatchInsert(DataSource dataSource) {
            super(dataSource, SQL);
            declareParameter(new SqlParameter(Types.INTEGER));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.TIMESTAMP));

            setBatchSize(10);
        }

    }

    private void run() {
        int count = 5000;
        for (int i = 0; i < count; i++) {
            this.batchInsert.update(new Object[] { i + 100L, "a" + i, "b" + i, null });
        }
    }

    BatchSqlUpdateDemo(DataSource dataSource) {
        this.batchInsert = new BatchInsert(dataSource);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", SqlUpdateDemo.class);
        BatchSqlUpdateDemo me = new BatchSqlUpdateDemo((DataSource)ac.getBean("dataSource"));
        me.run();
    }

}
