package com.apress.prospring2.ch14.dsl;

import java.math.BigDecimal;

/**
 * @author janm
 */
public interface DiscountCalculator {

    BigDecimal calculate(Invoice i);

}
