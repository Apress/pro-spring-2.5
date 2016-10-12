package com.apress.prospring2.ch06.proxies;

import com.apress.prospring2.ch06.services.DefaultStockService;
import com.apress.prospring2.ch06.services.StockService;

/**
 * @author janm
 */
public class ProxyDemo {

    public static void main(String[] args) {
        StockService dss = new DefaultStockService();
        System.out.println("reference = " + dss);
        dss.getStockLevel("X");
    }

}
