package com.apress.prospring2.ch09.spring;

import com.apress.prospring2.ch09.domain.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.MappingSqlQueryWithParameters;
import org.springframework.jdbc.object.SqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * @author janm
 */
class SqlQueryDemo {
    private static final Log logger = LogFactory.getLog(SqlQueryDemo.class);

    private static class SelectCustomer extends SqlQuery {
        private static final String SQL = "select * from t_customer";

        SelectCustomer(DataSource ds) {
            super(ds, SQL);
        }

        protected RowMapper newRowMapper(Object[] parameters, Map context) {
            return ParameterizedBeanPropertyRowMapper.newInstance(Customer.class);
        }
    }

    private static class MappingSelectCustomer extends MappingSqlQueryWithParameters {
        private static final String SQL = "select * from t_customer";
        private static final String LAST_LOGIN_DATE = "last_login";

        MappingSelectCustomer(DataSource ds) {
            super(ds, SQL);
        }

        protected Object mapRow(ResultSet rs, int rowNum, Object[] parameters, Map context) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setFirstName(rs.getString("last_name"));
            customer.setLastName(rs.getString("first_name"));
            customer.setLastLogin(rs.getDate("last_login"));
            if (rs.wasNull()) customer.setLastLogin(null);
            if (context != null) {
                if (context.containsKey(LAST_LOGIN_DATE)) customer.setLastLogin((Date)context.get("lastLogin"));
            }
            return customer;
        }

        public List execute(Date defaultLastLoginDate) {
            Map<String, Object> context = new HashMap<String, Object>();
            context.put(LAST_LOGIN_DATE, defaultLastLoginDate);
            return execute(context);
        }
    }

    private static class MappingSelectAllCustomers extends MappingSqlQuery {
        private static final String SQL = "select * from t_customer";

        MappingSelectAllCustomers(DataSource ds) {
            super(ds, SQL);
        }

        protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    private SelectCustomer selectCustomer;
    private MappingSelectCustomer mappingSelectCustomer;

    SqlQueryDemo(DataSource dataSource) {
        this.selectCustomer = new SelectCustomer(dataSource);
        this.mappingSelectCustomer = new MappingSelectCustomer(dataSource);
    }

    public void run() {
        List result;
        result = this.selectCustomer.execute();
        logger.debug(result);

        result = this.mappingSelectCustomer.execute(new Date());
        logger.debug(result);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", SqlUpdateDemo.class);
        SqlQueryDemo me = new SqlQueryDemo((DataSource)ac.getBean("dataSource"));
        me.run();
    }

}
