package com.apress.prospring2.ch09.dataaccess;

import com.apress.prospring2.ch09.domain.Customer;

import java.util.List;

/**
 * @author janm
 */
public interface CustomerDao {

    List<Customer> getAll();

    Customer getById(long id);
    
}
