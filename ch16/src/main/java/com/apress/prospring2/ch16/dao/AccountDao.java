package com.apress.prospring2.ch16.dao;

import com.apress.prospring2.ch16.domain.Account;
import com.apress.prospring2.ch16.domain.AccountIdentity;

/**
 * @author janm
 */
public interface AccountDao {

    void save(Account account);

    Account getByIdentity(AccountIdentity accountIdentity);

}
