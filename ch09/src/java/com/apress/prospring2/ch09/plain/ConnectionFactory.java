package com.apress.prospring2.ch09.plain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author janm
 */
abstract class ConnectionFactory {
    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@oracle.devcake.co.uk:1521:INTL";

    static Connection createConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new DatabaseException(e);
        }
        try {
            return DriverManager.getConnection(CONNECTION_STRING, "PROSPRING", "x******6");
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

}
