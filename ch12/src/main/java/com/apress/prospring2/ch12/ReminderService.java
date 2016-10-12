package com.apress.prospring2.ch12;

import org.springframework.transaction.support.TransactionSynchronizationUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author janm
 */
public class ReminderService {

    public void remindBirthdays() {
        System.out.println("In transaction? " + TransactionSynchronizationManager.isActualTransactionActive());
    }

}
