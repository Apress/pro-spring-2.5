package com.apress.prospring2.ch16.services;

import com.apress.prospring2.ch16.dao.AccountDao;
import com.apress.prospring2.ch16.domain.Account;
import com.apress.prospring2.ch16.domain.AccountIdentity;
import com.apress.prospring2.ch16.domain.BalanceMutator;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author janm
 */
public abstract class BankServiceSupport {
    private AccountDao accountDao;

    protected abstract static class BalanceMutatorSupport
            implements BalanceMutator {
        private BigDecimal amount;

        BalanceMutatorSupport(BigDecimal amount) {
            Assert.notNull(amount, "The 'amount' argument must not be null.");
            this.amount = amount;
        }

        protected final BigDecimal getAmount() {
            return this.amount;
        }

        protected abstract BigDecimal doMutate(BigDecimal balance);

        public final BigDecimal mutate(BigDecimal balance) {
            return doMutate(balance);
        }
    }

    protected static class CreditBalanceMutator
            extends BalanceMutatorSupport {

        CreditBalanceMutator(BigDecimal amount) {
            super(amount);
        }

        protected BigDecimal doMutate(BigDecimal balance) {
            return balance.add(getAmount());
        }
    }

    protected static class NoOverdraftDebitBalanceMutator
            extends BalanceMutatorSupport {

        NoOverdraftDebitBalanceMutator(BigDecimal amount) {
            super(amount);
        }

        protected BigDecimal doMutate(BigDecimal balance) {
            BigDecimal result = balance.subtract(getAmount());
            if (result.compareTo(new BigDecimal(0)) < 0)
                throw new InsufficientFundsException(getAmount().subtract(balance));
            return result;
        }
    }

    protected void doTransfer(AccountIdentity from, AccountIdentity to,
                         BigDecimal amount) {
        Account fromAccount = this.accountDao.getByIdentity(from);
        if (fromAccount == null) throw new UnknownAccountException(from);
        Account toAccount = this.accountDao.getByIdentity(to);
        if (toAccount == null) throw new UnknownAccountException(to);

        fromAccount.changeBalance(new NoOverdraftDebitBalanceMutator(amount));
        toAccount.changeBalance(new CreditBalanceMutator(amount));

        this.accountDao.save(fromAccount);
        this.accountDao.save(toAccount);
    }

    protected BigDecimal doGetBalance(AccountIdentity accountIdentity) {
        Account account = this.accountDao.getByIdentity(accountIdentity);
        if (account == null) throw new UnknownAccountException(accountIdentity);
        return account.getBalance();
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
