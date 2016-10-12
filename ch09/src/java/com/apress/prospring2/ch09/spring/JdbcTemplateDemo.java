package com.apress.prospring2.ch09.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author janm
 */
class JdbcTemplateDemo {
    private static Log logger = LogFactory.getLog(JdbcTemplateDemo.class);
    private JdbcTemplate jdbcTemplate;

    private static class MyPreparedStatementCreator implements PreparedStatementCreator {
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            PreparedStatement ps = connection.prepareStatement("select * from t_x where id=?");
            ps.setLong(1, 1L);
            return ps;
        }
    }

    private static class MyPreparedStatementCallback implements PreparedStatementCallback {
        public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
            ResultSet rs = preparedStatement.executeQuery();
            List<Long> ids = new LinkedList<Long>();
            while (rs.next()) {
                ids.add(rs.getLong(1));
            }
            rs.close();
            return ids;
        }
    }

    private static class MyCallableStatementCreator implements CallableStatementCreator {
        public CallableStatement createCallableStatement(Connection connection) throws SQLException {
            CallableStatement cs = connection.prepareCall("{? = call f_calculate}");
            cs.registerOutParameter(1, Types.INTEGER);
            return cs;
        }
    }

    private static class MyCallableStatementCallback implements CallableStatementCallback {
        public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
            callableStatement.execute();
            return callableStatement.getLong(1);
        }
    }

    private void runExecute() {
        this.jdbcTemplate.execute(new ConnectionCallback() {
            public Object doInConnection(Connection connection) throws SQLException, DataAccessException {
                PreparedStatement createTable = connection.prepareStatement("create table t_x (id number(19,0) not null, constraint pk_x primary key(id))");
                createTable.execute();
                return null;
            }
        });

        this.jdbcTemplate.execute(new StatementCallback() {
            public Object doInStatement(Statement statement) throws SQLException, DataAccessException {
                return statement.execute("insert into t_x (id) values (1)");
            }
        });

        this.jdbcTemplate.execute("insert into t_x (id) values (2)");

        List<Long> ids;
        ids = (List<Long>) this.jdbcTemplate.execute(new MyPreparedStatementCreator(), new MyPreparedStatementCallback());
        logger.debug(ids);

        ids = (List<Long>) this.jdbcTemplate.execute("select id from t_x", new MyPreparedStatementCallback());
        logger.debug(ids);

        logger.debug(this.jdbcTemplate.execute(new MyCallableStatementCreator(), new MyCallableStatementCallback()));

        this.jdbcTemplate.execute("{call p_actstartled(42)}", new CallableStatementCallback() {
            public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                callableStatement.execute();
                return null;
            }
        });

        this.jdbcTemplate.execute("drop table t_x");
    }

    private void runQuery() {
        Long count = (Long) this.jdbcTemplate.query("select count(*) from t_customer", new ResultSetExtractor() {
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
                return null;
            }
        });
        logger.debug(count);
        this.jdbcTemplate.query("select first_name, last_name, last_login from t_customer where last_login is null",
                new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        while (resultSet.next()) {
                            // send email to resultSet.getString(1)
                        }
                    }
                });
        List<String> names = this.jdbcTemplate.query("select first_name from t_customer", new RowMapper() {
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(1);
            }
        });
        logger.debug(names);
        String machaceksName = (String) this.jdbcTemplate.query(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                return connection.prepareStatement("select first_name from t_customer where last_name like ?");
            }
        }, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, "Mach%");
            }
        }, new ResultSetExtractor() {
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
                return null;
            }
        });
        logger.debug(machaceksName);
        Long maxId = (Long) this.jdbcTemplate.query(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                return connection.prepareStatement("select max(id) from t_customer");
            }
        }, new ResultSetExtractor() {
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
                return null;
            }
        });
        logger.debug(maxId);
        String firstCustomersName = (String) this.jdbcTemplate.query("select first_name from t_customer where id=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setLong(1, 1L);
            }
        }, new FirstColumnStringExtractor());
        logger.debug(firstCustomersName);
        String firstCustomersLastName = (String) this.jdbcTemplate.query(
                "select last_name from t_customer where id=?",
                new Object[]{1L}, new int[]{Types.INTEGER},
                new FirstColumnStringExtractor());
        logger.debug(firstCustomersLastName);
        logger.debug(this.jdbcTemplate.query(
                "select last_name from t_customer where id=?",
                new Object[]{1L},
                new FirstColumnStringExtractor()
        ));
        this.jdbcTemplate.query(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                return connection.prepareStatement("select last_name from t_customer where last_login is null");
            }
        }, new StringExtractingRowCallbackHandler());
        
        this.jdbcTemplate.query("select last_name from t_customer where id > ?",
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setLong(1, 1L);
                    }
                },
                new StringExtractingRowCallbackHandler());
        this.jdbcTemplate.query("select first_name from t_customer where last_login < ?",
                new Object[] { new java.util.Date() },
                new int[] { Types.TIMESTAMP },
                new StringExtractingRowCallbackHandler());
        this.jdbcTemplate.query("select first_name from t_customer where id=?",
                new Object[] { 1L },
                new StringExtractingRowCallbackHandler());

        logger.debug(this.jdbcTemplate.query(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                return connection.prepareStatement("select first_name from t_customer");
            }
        }, new FirstColumnStringRowMapper()));
        logger.debug(this.jdbcTemplate.query("select first_name from t_customer where id=?",
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setLong(1, 1L);
                    }
                },
                new FirstColumnStringRowMapper()));
        logger.debug(this.jdbcTemplate.query("select first_name from t_customer where id=?",
                new Object[] { 1L },
                new int[] { Types.INTEGER },
                new FirstColumnStringRowMapper()));
        logger.debug(this.jdbcTemplate.query("select first_name from t_customer where id=?",
                new Object[] { 1L },
                new FirstColumnStringRowMapper()));

        logger.debug(this.jdbcTemplate.queryForList("select id from t_customer", Long.class));
        logger.debug(this.jdbcTemplate.queryForMap("select * from t_customer"));
    }

    private void runCall() {
        this.jdbcTemplate.call(new MyCallableStatementCreator(), null);
    }

    private void runUpdate() {
        this.jdbcTemplate.update("update t_customer set first_name = first_name||'x'");
        // this.jdbcTemplate.update(new InsertPreparedStatementCreator());

        this.jdbcTemplate.update("delete from t_customer where id=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, -1L);
            }
        });
        this.jdbcTemplate.update("update t_customer set first_name=? where id=?", new Object[] { "Jenda", 1L }, new int[] { Types.VARCHAR, Types.INTEGER });
    }

    private void runBatch() {
        final int count = 2000;
        final List<String> firstNames = new ArrayList<String>(count);
        final List<String> lastNames = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            firstNames.add("First Name " + i);
            lastNames.add("Last Name " + i);
        }
        this.jdbcTemplate.batchUpdate("insert into t_customer (id, first_name, last_name, last_login, comments) values (?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, i + 10);
                ps.setString(2, firstNames.get(i));
                ps.setString(3, lastNames.get(i));
                ps.setNull(4, Types.TIMESTAMP);
                ps.setNull(5, Types.CLOB);
            }

            public int getBatchSize() {
                return count;
            }
        });

        this.jdbcTemplate.batchUpdate(new String[] {
                "update t_customer set first_name = 'FN#'||id",
                "delete from t_customer where id > 2"
        });
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", JdbcTemplateDemo.class);
        JdbcTemplateDemo demo = (JdbcTemplateDemo) ac.getBean("jdbcTemplateDemo");
        //demo.runExecute();
        //demo.runQuery();
        //demo.runCall();
        //demo.runUpdate();
        demo.runBatch();
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class FirstColumnStringExtractor implements ResultSetExtractor {
        public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
            return null;
        }
    }

    private static class StringExtractingRowCallbackHandler implements RowCallbackHandler {
        public void processRow(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                logger.debug(resultSet.getString(1));
            }
        }
    }

    private static class FirstColumnStringRowMapper implements RowMapper {
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString(1);
        }
    }
}
