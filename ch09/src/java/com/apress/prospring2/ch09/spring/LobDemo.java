package com.apress.prospring2.ch09.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.LobHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author janm
 */
class LobDemo {
    private static final Log logger = LogFactory.getLog(LobDemo.class);
    private JdbcTemplate jdbcTemplate;
    private LobHandler lobHandler;

    LobDemo(DataSource dataSource, LobHandler lobHandler) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.lobHandler = lobHandler;
    }

    private void runInTemplate() {
        this.jdbcTemplate.update(
                "insert into t_customer (id, first_name, last_name, last_login, comments) " +
                        "values (?, ?, ?, ?, ?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, 2L);
                ps.setString(2, "Jan");
                ps.setString(3, "Machacek");
                ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                lobHandler.getLobCreator().setClobAsString(ps, 5, "This is a loooong String!");
            }
        });

        logger.debug(this.jdbcTemplate.query("select comments from t_customer where id=?", new Object[] { 2L }, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return lobHandler.getClobAsString(rs, 1);
            }
        }));

        logger.debug(this.jdbcTemplate.query("select comments from t_customer where id=?", new Object[] { 2L }, new RowMapper() {
            private String readAsAscii(InputStream is) throws IOException {
                StringBuffer out = new StringBuffer();
                byte[] buffer = new byte[1024];
                int read;
                try {
                    while ((read = is.read(buffer, 0, buffer.length)) > 0) {
                        for (int i = 0; i < read; i++) {
                            out.append(String.format("%x", buffer[i]));
                        }
                    }
                } finally {
                    is.close();
                }
                return out.toString();
            }

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                InputStream stream = lobHandler.getClobAsAsciiStream(rs, 1);
                try {
                    return readAsAscii(stream);
                } catch (IOException ex) {
                    // ssh, no-one will ever know!
                }
                return null;
            }
        }));
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", SqlUpdateDemo.class);
        LobDemo me = new LobDemo((DataSource)ac.getBean("dataSource"), (LobHandler)ac.getBean("lobHandler"));
        me.runInTemplate();
    }
}
