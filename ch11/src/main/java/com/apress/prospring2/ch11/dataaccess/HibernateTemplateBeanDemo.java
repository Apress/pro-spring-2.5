package com.apress.prospring2.ch11.dataaccess;

import org.hibernate.Session;
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
public class HibernateTemplateBeanDemo {

    public static void main(String[] args) throws Exception {
        DaoDemoUtils.buildJndi();
        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource-context-ht.xml", DaoDemo.class);
        HibernateTemplate template = (HibernateTemplate) ac.getBean("hibernateTemplate");
        template.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                // do the work
                return null;
            }
        });
    }

}