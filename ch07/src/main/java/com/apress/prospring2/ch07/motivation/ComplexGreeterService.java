package com.apress.prospring2.ch07.motivation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * @author anirvanc
 */
public class ComplexGreeterService implements GreeterService {
    private static final Log logger = LogFactory.getLog(ComplexGreeterService.class);
    private List<String> greetings;

    public void greet() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            logger.debug("Running in transaction...");
        }

        for (String greeting : this.greetings) {
            logger.debug(greeting);
        }
    }

    public void setGreetings(List<String> greetings) {
        this.greetings = greetings;
    }
}
