package com.apress.prospring2.ch14.dsl;

/**
 * @author janm
 */
public class RandomCustomerScoringService implements CustomerScoringService {
    
    public double score(Customer customer) {
        return Math.random();
    }
}
