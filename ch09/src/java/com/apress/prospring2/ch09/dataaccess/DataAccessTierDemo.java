package com.apress.prospring2.ch09.dataaccess;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
class DataAccessTierDemo {
    private static final Log logger = LogFactory.getLog(DataAccessTierDemo.class);
    private CustomerDao customerDao;

    DataAccessTierDemo(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private void run() {
        logger.debug(this.customerDao.getAll());
        logger.debug(this.customerDao.getById(1L));
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("dataaccess-tier-context.xml", DataAccessTierDemo.class);
        DataAccessTierDemo me = new DataAccessTierDemo((CustomerDao)ac.getBean("customerDao"));
        me.run();
    }


}
