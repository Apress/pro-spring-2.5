package com.apress.prospring2.ch10.dataaccess.ibatis;

import com.apress.prospring2.ch10.dataaccess.OrderDao;
import com.apress.prospring2.ch10.domain.Order;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * @author Aleksa Vukotic
 */
public class SqlMapClientOrderDao extends SqlMapClientDaoSupport implements OrderDao {
    public Order getById(int orderId) {
        return (Order) getSqlMapClientTemplate().queryForObject("getOrderById", orderId);
    }
}
