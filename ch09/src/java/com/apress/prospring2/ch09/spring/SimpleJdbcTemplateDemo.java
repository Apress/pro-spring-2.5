package com.apress.prospring2.ch09.spring;

import com.apress.prospring2.ch09.domain.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author janm
 */
class SimpleJdbcTemplateDemo {
    private static final Log logger = LogFactory.getLog(SimpleJdbcTemplateDemo.class);
    private SimpleJdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private DataSource mysqlDataSource;

    SimpleJdbcTemplateDemo(DataSource dataSource, DataSource mysqlDataSource) {
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.dataSource = dataSource;
        this.mysqlDataSource = mysqlDataSource;
    }

    private void run() {
        List<Customer> customers = this.jdbcTemplate.query(
                "select * from t_customer",
                ParameterizedBeanPropertyRowMapper.newInstance(Customer.class));
        logger.debug(customers);

        Customer customer = new Customer();
        customer.setId(3L);
        customer.setFirstName("FN");
        customer.setLastName("LN");
        customer.setLastLogin(new Date());
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(customer);
        this.jdbcTemplate.update(
                "insert into t_customer (id, first_name, last_name, last_login, comments) " +
                        "values (:id, :firstName, :lastName, :lastLogin, :comments)",
                parameterSource);

        int count = 1000;
        SqlParameterSource[] source = new SqlParameterSource[count];
        for (int i = 0 ; i < count; i++) {
            Customer c = new Customer();
            c.setId(i + 100L);
            c.setFirstName("FN #" + i);
            c.setLastName("LN #" + i);
            c.setLastLogin(new Date());
            source[i] = new BeanPropertySqlParameterSource(c);
        }
        this.jdbcTemplate.batchUpdate(
                "insert into t_customer (id, first_name, last_name, last_login, comments) " +
                        "values (:id, :firstName, :lastName, :lastLogin, :comments)", source);
    }

    private void runCall() {
        BigDecimal meaningOfLife = new SimpleJdbcCall(this.dataSource).
                withFunctionName("f_calculate").
                withReturnValue().
                executeObject(BigDecimal.class, Collections.emptyMap());
        logger.debug(meaningOfLife);

        Map<String,Object> result = new SimpleJdbcCall(this.dataSource).
                withProcedureName("simplejdbc.p_find_customer").
                withoutProcedureColumnMetaDataAccess().
                returningResultSet("rc_customer_type", ParameterizedBeanPropertyRowMapper.newInstance(Customer.class)).
                execute(new MapSqlParameterSource("rc_customer_type", null));
        logger.debug(result);
    }

    private void runInsert() {
        Customer customer = new Customer();
        customer.setId(3L);
        customer.setFirstName("FN");
        customer.setLastName("LN");
        customer.setLastLogin(new Date());
        customer.setComments("This is a long CLOB string. Mu-har-har!");

//        SimpleJdbcInsert insert = new SimpleJdbcInsert(this.dataSource);
//        insert.
//                withTableName("t_customer").
//                usingColumns("id", "first_name", "last_name", "last_login", "comments").
//                execute(new BeanPropertySqlParameterSource(customer));

        long id = new SimpleJdbcInsert(this.mysqlDataSource).
                withTableName("t_customer").
                usingColumns("first_name", "last_name", "last_login", "comments").
                usingGeneratedKeyColumns("id").
                executeAndReturnKey(new BeanPropertySqlParameterSource(customer)).longValue();
        logger.debug(id);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", SqlUpdateDemo.class);
        SimpleJdbcTemplateDemo me = new SimpleJdbcTemplateDemo(
                (DataSource)ac.getBean("dataSource"),
                (DataSource)ac.getBean("mysqlDataSource"));
        me.runInsert();
    }

}
