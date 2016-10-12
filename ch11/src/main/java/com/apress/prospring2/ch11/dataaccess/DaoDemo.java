package com.apress.prospring2.ch11.dataaccess;

import com.apress.prospring2.ch11.util.DaoDemoUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author janm
 */
public class DaoDemo {

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource-context-minimal.xml", DaoDemo.class);
        SessionFactory sessionFactory = (SessionFactory)ac.getBean("hibernateSessionFactory");
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            // do work
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

}
