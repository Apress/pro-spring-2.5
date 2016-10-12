package com.apress.prospring2.ch09.dataaccess.jdbc;

import com.apress.prospring2.ch09.dataaccess.CustomerDao;
import com.apress.prospring2.ch09.domain.Customer;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import java.util.List;

/**
 * @author janm
 */
public class SimpleJdbcCustomerDao extends SimpleJdbcDaoSupport implements CustomerDao {

    public List<Customer> getAll() {
        return getSimpleJdbcTemplate().query("select * from t_customer",
                ParameterizedBeanPropertyRowMapper.newInstance(Customer.class));
    }

    public Customer getById(long id) {
        return getSimpleJdbcTemplate().queryForObject(
                "select * from t_customer where id=?",
                Customer.class,
                id);
    }
}
