package com.apress.prospring2.ch11.dataaccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;

import java.sql.SQLException;

import com.apress.prospring2.ch11.util.DaoDemoUtils;

/**
 * @author janm
 */
public class HibernateTemplateDemo {

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource-context-minimal.xml", DaoDemo.class);
        SessionFactory sessionFactory = (SessionFactory)ac.getBean("hibernateSessionFactory");
        HibernateTemplate template = new HibernateTemplate(sessionFactory);
        template.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                // do the work
                return null;
            }
        });
    }

}
