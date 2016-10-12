package com.apress.prospring2.ch06.services;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author janm
 */
public interface StockService {
    long getStockLevel(String sku);

    long getPredictedStockLevel(String sku);

    void applyDiscounts(Date cutoffDate, BigDecimal maximumDiscount);
}
