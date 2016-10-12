package com.apress.prospring2.ch10;

import com.apress.prospring2.ch10.dataaccess.CustomerDao;
import com.apress.prospring2.ch10.dataaccess.OrderDao;
import com.apress.prospring2.ch10.domain.Customer;
import com.apress.prospring2.ch10.domain.CustomerDetail;
import com.apress.prospring2.ch10.domain.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Aleksa Vukotic
 */
public class Main {

    private ApplicationContext context;

    private void run() throws Exception {
        System.out.println("Initializing application");
        context = new ClassPathXmlApplicationContext("dataaccess-context.xml");

        System.out.println("Getting customerDao");
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");

        // get the context and customerDao
        Date today = Calendar.getInstance().getTime();

        System.out.println("Inserting new Customer record");
        Customer newcustomer = new Customer();
        newcustomer.setFirstName("Jack");
        newcustomer.setLastName("Bower");
        newcustomer.setLastLogin(today);
        CustomerDetail detail = new CustomerDetail();
        detail.setId(101L);
        newcustomer.setCustomerDetail(detail);
        customerDao.save(newcustomer);

        System.out.println("Customer inserted " + newcustomer);
        List<Customer> customers = customerDao.getAll();
        for (Customer customer : customers) {

            System.out.println(customer);

        }

        System.out.println("Done");
        customers = customerDao.getByLastNameAndLastLogin("Smith", new SimpleDateFormat("dd/MM/yyyy").parse("08/08/2007"));
        for (Customer customer : customers) {
            customer = customerDao.getById(2L);
            System.out.println(customer);

        }
        Customer customer1 = customerDao.getById(1L);
        System.out.println(customer1);

        Customer customer2 = customerDao.getById(2L);
        System.out.println(customer2);

        OrderDao orderDao = (OrderDao) context.getBean("orderDao");
        Order order = orderDao.getById(1);
        System.out.println(order);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
