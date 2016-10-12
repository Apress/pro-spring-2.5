package com.apress.prospring2.ch09.plain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author janm
 */
class CallableDemo {

    public static void main(String[] args) throws SQLException {
        CallableStatement cs;
        Connection connection = ConnectionFactory.createConnection();
        cs = connection.prepareCall("{? = call f_calculate}");
        cs.registerOutParameter(1, Types.INTEGER);
        cs.execute();
        long meaningOfLife = cs.getLong(1);
        System.out.println(meaningOfLife);

        cs = connection.prepareCall("{call p_actstartled(?)}");
        cs.setLong(1, meaningOfLife);
        cs.execute();

        connection.close();
    }

}
