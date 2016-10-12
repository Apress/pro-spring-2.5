package com.apress.prospring2.ch08.paging;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;

/**
 * @author janm
 */
public class HibernateResultDao extends HibernateDaoSupport implements ResultDao {
    
    public ResultSearchResult search(final ResultSearchArgument a) {
        return (ResultSearchResult) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query;
                ResultSearchResult result = new ResultSearchResult();
                query = session.createQuery("from Result where name = :s");
                query.setString("s", a.getS());
                query.setFirstResult(a.getFirstResult());
                query.setMaxResults(a.getMaxResults());
                result.setResult(query.list());

                query = session.createQuery("select count(*) from Result where name = :s");
                query.setString("s", a.getS());
                result.setTotalResults((Long)query.uniqueResult());
                
                return result;
            }
        });
    }
}
