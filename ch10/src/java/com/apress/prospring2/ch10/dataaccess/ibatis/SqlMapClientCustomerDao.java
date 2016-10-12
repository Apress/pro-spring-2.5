package com.apress.prospring2.ch10.dataaccess.ibatis;

import com.apress.prospring2.ch10.dataaccess.CustomerDao;
import com.apress.prospring2.ch10.domain.Customer;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aleksa Vukotic
 */
public class SqlMapClientCustomerDao extends SqlMapClientDaoSupport implements CustomerDao {

    public List<Customer> getAll() {
        return getSqlMapClientTemplate().queryForList("getAllCustomers");
    }

    public List<Customer> getByNameAndRunDate(String name, Date runDate) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void insert(Customer customer) {
        getSqlMapClientTemplate().insert("insertCustomer", customer);
    }

    private void update(Customer customer) {
        getSqlMapClientTemplate().update("updateCustomer", customer);
    }

    public void save(Customer customer) {
        if (customer.getId() == null || customer.getId() == 0) {
            insert(customer);
        } else {
            update(customer);
        }
    }

    public void delete(Long id) {
        getSqlMapClientTemplate().delete("deleteCustomer", id);
    }

    public Customer getById(Long id) {

        return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerById", id);
    }

    public List<Customer> getByLastNameAndLastLoginMap(String lastName, Date lastLogin) {
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("lastName", lastName);
        parms.put("lastLogin", lastLogin);
        return getSqlMapClientTemplate().queryForList("getCustomersByLastNameAndLastLoginMap", parms);
    }

    public List<Customer> getByLastNameAndLastLogin(String lastName, Date lastLogin) {
        Customer customer = new Customer();
        customer.setLastName(lastName);
        customer.setLastLogin(lastLogin);
        return getSqlMapClientTemplate().queryForList("getCustomersByLastNameAndLastLoginDO", customer);
    }

    public void updateLastName(Long id, String lastName) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setLastName(lastName);
        getSqlMapClientTemplate().update("updateCustomerNameDO", customer);
    }
}
