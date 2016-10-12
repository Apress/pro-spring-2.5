package com.apress.prospring2.ch09.dataaccess.jdbc;

import com.apress.prospring2.ch09.dataaccess.CustomerDao;
import com.apress.prospring2.ch09.domain.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlQuery;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @author janm
 */
public class JdbcCustomerDao extends JdbcDaoSupport implements CustomerDao {
    private SelectCustomerById selectCustomerById;

    private static class SelectCustomerById extends SqlQuery {

        SelectCustomerById(DataSource ds) {
            super(ds, "select * from t_customer where id=?");
            declareParameter(new SqlParameter(Types.INTEGER));
        }

        protected RowMapper newRowMapper(Object[] parameters, Map context) {
            return ParameterizedBeanPropertyRowMapper.newInstance(Customer.class);
        }
    }

    @Override
    protected void initDao() throws Exception {
        this.selectCustomerById = new SelectCustomerById(getDataSource());
    }

    @SuppressWarnings({"unchecked"})
    public List<Customer> getAll() {
        return getJdbcTemplate().query("select * from t_customer", ParameterizedBeanPropertyRowMapper.newInstance(Customer.class));
    }

    public Customer getById(long id) {
        return (Customer)this.selectCustomerById.findObject(id);
    }
}
