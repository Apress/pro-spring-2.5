package com.apress.prospring2.ch16.services;

import com.apress.prospring2.ch16.Grinch;
import com.apress.prospring2.ch16.dao.AccountDao;
import com.apress.prospring2.ch16.domain.Account;
import com.apress.prospring2.ch16.domain.AccountIdentity;
import com.apress.prospring2.ch16.synchronization.WorkerFactory;
import com.apress.prospring2.ch16.synchronization.Worker;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author janm
 */
public class DefaultAccountService implements AccountService {
    private AccountDao accountDao;
    private WorkerFactory workerFactory;

    @Transactional
    public AccountIdentity create() {
        Random random = new Random();
        StringBuilder number = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            number.append(random.nextInt(9));
        }
        AccountIdentity ai = new AccountIdentity("011001", number.toString());
        Account account = new Account();
        account.setId(System.currentTimeMillis());
        account.setIdentity(ai);
        account.setBalance(BigDecimal.ZERO);
        Worker worker = this.workerFactory.create();
        worker.work(10);
        this.accountDao.save(account);
        worker.work(20);

        Grinch.ruin();
        
        return ai;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setWorkerFactory(WorkerFactory workerFactory) {
        this.workerFactory = workerFactory;
    }
}
