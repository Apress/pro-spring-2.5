package com.apress.prospring2.ch09.plain;

import java.sql.*;

/**
 * @author janm
 */
class SelectDemo {
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
                    "select s_customer_id.nextval from dual");
        } catch (SQLException e) {
            return;
        }
        long id;
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
                System.out.println("The id was " + id);
            }
        } catch (SQLException e) {
            return;
        }

        // use the id

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
