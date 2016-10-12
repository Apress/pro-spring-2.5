package com.apress.prospring2.ch10.dataaccess;

import com.apress.prospring2.ch10.domain.Order;

/**
 * @author Aleksa Vukotic
 */
public interface OrderDao {
    public Order getById(int orderId);
}
