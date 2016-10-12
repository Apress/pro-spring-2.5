package com.apress.prospring2.ch06.services;

import org.springframework.aop.framework.AopContext;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author janm
 */
public class DefaultStockService implements StockService {

    public long getStockLevel(String sku) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException ignored) {
        }
        return getPredictedStockLevel(sku) / 2L;
//        return ((StockService)AopContext.currentProxy()).getPredictedStockLevel(sku) / 2L;
    }

    public long getPredictedStockLevel(String sku) {
        return 6L * sku.hashCode();
    }

    public void applyDiscounts(Date cutoffDate, BigDecimal maximumDiscount) {
        // do some work
    }

}
