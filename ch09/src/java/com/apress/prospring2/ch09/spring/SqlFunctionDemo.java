package com.apress.prospring2.ch09.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;

/**
 * @author janm
 */
class SqlFunctionDemo {
    private SqlFunction two;
    private static final Log logger = LogFactory.getLog(SqlFunctionDemo.class);

    SqlFunctionDemo(DataSource dataSource) {
        this.two = new SqlFunction(dataSource, "select 1+1 from dual");
    }

    private void run() {
        logger.debug(this.two.runGeneric());
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", SqlFunctionDemo.class);
        SqlFunctionDemo me = new SqlFunctionDemo((DataSource)ac.getBean("dataSource"));
        me.run();
    }

}
