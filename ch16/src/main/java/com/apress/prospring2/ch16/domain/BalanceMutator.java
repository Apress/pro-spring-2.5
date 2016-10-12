package com.apress.prospring2.ch16.domain;

import java.math.BigDecimal;

/**
 * @author janm
 */
public interface BalanceMutator {

    BigDecimal mutate(BigDecimal balance);

}
