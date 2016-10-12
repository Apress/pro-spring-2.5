package com.apress.prospring2.ch10.dataaccess;

import com.apress.prospring2.ch10.domain.Customer;

import java.util.Date;
import java.util.List;

/**
 * @author Aleksa Vukotic
 */
public interface CustomerDao {
    public List<Customer> getAll();

    public List<Customer> getByNameAndRunDate(String name, Date runDate);

    public void save(Customer customer);

    public void delete(Long id);

    public Customer getById(Long id);

    public List<Customer> getByLastNameAndLastLogin(String lastName, Date lastLogin);

    public void updateLastName(Long id, String lastName);
}
