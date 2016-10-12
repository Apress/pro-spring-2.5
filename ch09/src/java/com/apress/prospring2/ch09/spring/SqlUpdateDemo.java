package com.apress.prospring2.ch09.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;

/**
 * @author janm
 */
class SqlUpdateDemo {
    private JdbcTemplate jdbcTemplate;
    private Insert insert;
    private DeleteWhereIdGreater deleteWhereIdGreater;
    private NamedInsert namedInsert;
    private MySqlInsert mySqlInsert;

    private static class Insert extends SqlUpdate {
        private static final String SQL = "insert into t_customer (id, first_name, last_name, last_login, " +
                "comments) values (?, ?, ?, ?, ?)";

        Insert(DataSource dataSource) {
            super(dataSource, SQL);
            declareParameter(new SqlParameter(Types.INTEGER));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.TIMESTAMP));
            declareParameter(new SqlParameter(Types.CLOB));
        }

        void insert(long id, String firstName, String lastName, Date lastLogin, String comments) {
            update(new Object[] { id, firstName, lastName, lastLogin, comments });
        }
    }

    private static class MySqlInsert extends SqlUpdate {
        private static final String SQL = "insert into t_customer (first_name, last_name, last_login, " +
                "comments) values (?, ?, ?, ?)";

        MySqlInsert(DataSource dataSource) {
            super(dataSource, SQL);
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.TIMESTAMP));
            declareParameter(new SqlParameter(Types.CLOB));
            setMaxRowsAffected(1);
            setGeneratedKeysColumnNames(new String[] { "id" });
            setReturnGeneratedKeys(true);
        }

        long insert(String firstName, String lastName, Date lastLogin, String comments) {
            List<String> generatedKeys = new ArrayList<String>(1);
            generatedKeys.add("id");
            
            KeyHolder kh = new GeneratedKeyHolder(generatedKeys);
            update(new Object[] { firstName, lastName, lastLogin, comments }, kh);
            return (Long) kh.getKey();
        }

    }

    private static class NamedInsert extends SqlUpdate {
        private static final String SQL = "insert into t_customer (id, first_name, last_name, last_login, " +
                "comments) values (:id, :firstName, :lastName, :lastLogin, :comments)";

        NamedInsert(DataSource dataSource) {
            super(dataSource, SQL);
            declareParameter(new SqlParameter(Types.INTEGER));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.TIMESTAMP));
            declareParameter(new SqlParameter(Types.CLOB));
        }
    }

    private static class DeleteWhereIdGreater extends SqlUpdate {
        private static final String SQL = "delete from t_customer where id > ?";

        DeleteWhereIdGreater(DataSource dataSource) {
            super(dataSource, SQL);
            declareParameter(new SqlParameter(Types.INTEGER));
        }
    }

    SqlUpdateDemo(DataSource dataSource, DataSource mysqlDataSource) {
        this.insert = new Insert(dataSource);
        this.mySqlInsert = new MySqlInsert(mysqlDataSource);
        this.namedInsert = new NamedInsert(dataSource);
        this.deleteWhereIdGreater = new DeleteWhereIdGreater(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void runInsert() {
        this.insert.update(new Object[] { 3L, "Jan", "Machacek", null, null });
        this.insert.update(new Object[] { 4L, "Joe", "Doe", null, null });
        this.insert.insert(5L, "Anirvan", "Chakraborty", null, null);

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("id", 6L);
        parameterMap.put("firstName", "John");
        parameterMap.put("lastName", "Appleseed");
        parameterMap.put("lastLogin", null);
        parameterMap.put("comments", null);
        this.namedInsert.updateByNamedParam(parameterMap);

        this.mySqlInsert.insert("Jan", "Machacek", null, null);

        this.deleteWhereIdGreater.update(1L);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", SqlUpdateDemo.class);
        SqlUpdateDemo me = new SqlUpdateDemo((DataSource)ac.getBean("dataSource"), (DataSource)ac.getBean("mysqlDataSource"));
        me.runInsert();
    }

}
