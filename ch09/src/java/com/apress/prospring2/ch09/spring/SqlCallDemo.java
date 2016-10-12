package com.apress.prospring2.ch09.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author janm
 */
class SqlCallDemo {
    private static final Log logger = LogFactory.getLog(SqlCallDemo.class);

    private MeaningOfLife meaningOfLife;
    private ActStartled actStartled;

    private static class MeaningOfLife extends StoredProcedure {
        private static final String SQL = "f_calculate";

        MeaningOfLife(DataSource dataSource) {
            super(dataSource, SQL);
            setFunction(true);
            declareParameter(new SqlOutParameter("n", Types.INTEGER));
        }

        int executeAndGet() {
           return (Integer)execute(Collections.emptyMap()).values().iterator().next();
        }
    }

    private static class ActStartled extends StoredProcedure {
        private static final String SQL = "p_actstartled";

        ActStartled(DataSource dataSource) {
            super(dataSource, SQL);
            declareParameter(new SqlParameter("n", Types.INTEGER));
        }

        void execute(int value) {
            Map<String, Object> parameters = new HashMap<String, Object>(1);
            parameters.put("n", value);
            execute(parameters);
        }
    }

    SqlCallDemo(DataSource dataSource) {
        this.meaningOfLife = new MeaningOfLife(dataSource);
        this.actStartled = new ActStartled(dataSource);
    }

    private void run() {
        Map result = this.meaningOfLife.execute(Collections.emptyMap());
        logger.debug(result.values().iterator().next());
        this.actStartled.execute(result);

        // run better
        int m = this.meaningOfLife.executeAndGet();
        this.actStartled.execute(m);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcdao-context.xml", SqlUpdateDemo.class);
        SqlCallDemo me = new SqlCallDemo((DataSource)ac.getBean("dataSource"));
        me.run();
    }

}
