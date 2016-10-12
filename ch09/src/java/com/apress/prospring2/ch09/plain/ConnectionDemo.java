package com.apress.prospring2.ch09.plain;

import java.sql.*;

/**
 * @author janm
 */
class ConnectionDemo {
    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@oracle.devcake.co.uk:1521:INTL";

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            return;
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, "PROSPRING", "x******6");
        } catch (SQLException e) {
            return;
        }
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "insert into t_customer (id, first_name, last_name, last_login, comments)" +
                    "values (?, ?, ?, ?, ?)");
        } catch (SQLException e) {
            return;
        }
        try {
            preparedStatement.setLong(1, 1L);
            preparedStatement.setString(2, "Jan");
            preparedStatement.setString(3, "Machacek");
            preparedStatement.setNull(4, Types.TIMESTAMP);
            preparedStatement.setNull(5, Types.CLOB);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return;
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            // noop
        }
    }

}
