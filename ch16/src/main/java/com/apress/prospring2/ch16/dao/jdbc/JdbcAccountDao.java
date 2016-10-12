package com.apress.prospring2.ch16.dao.jdbc;

import com.apress.prospring2.ch16.Grinch;
import com.apress.prospring2.ch16.dao.AccountDao;
import com.apress.prospring2.ch16.domain.Account;
import com.apress.prospring2.ch16.domain.AccountIdentity;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author janm
 */
public class JdbcAccountDao extends SimpleJdbcDaoSupport implements AccountDao {
    private static final String INSERT_SQL =
            "insert into t_account (id, sort_code, number_, balance) values " +
                    "(?, ?, ?, ?)";
    private static final String UPDATE_SQL =
            "update t_account set balance=? where id=?";
    private static final String SELECT_SQL =
            "select id, sort_code, number_, balance from t_account " +
                    "where sort_code=? and number_=?";

    public void save(Account account) {
        Grinch.ruin();
        if (account.getId() == null) {
            // insert
            getSimpleJdbcTemplate().update(INSERT_SQL,
                    account.getId(),
                    account.getIdentity().getSortCode(),
                    account.getIdentity().getNumber(),
                    account.getBalance());
        } else {
            // update
            getSimpleJdbcTemplate().update(UPDATE_SQL,
                    account.getBalance(),
                    account.getId());
        }
    }

    public Account getByIdentity(AccountIdentity accountIdentity) {
        return getSimpleJdbcTemplate().queryForObject(SELECT_SQL,
                new ParameterizedBeanPropertyRowMapper<Account>() {
                    public Account mapRow(ResultSet rs, int rowNumber)
                            throws SQLException {

                        Account account = new Account();
                        account.setId(rs.getLong(1));
                        AccountIdentity identity = new AccountIdentity(
                                rs.getString(2),
                                rs.getString(3)
                        );
                        account.setIdentity(identity);
                        account.setBalance(rs.getBigDecimal(4));
                        return account;
                    }
                }, accountIdentity.getSortCode(), accountIdentity.getNumber());
    }
}
