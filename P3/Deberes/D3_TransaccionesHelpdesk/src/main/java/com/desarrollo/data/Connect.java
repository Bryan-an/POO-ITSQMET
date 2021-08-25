package com.desarrollo.data;

import java.sql.*;

public class Connect {

    //Fields
    private static final String JDBC_URL
            = "jdbc:mysql://localhost:3306/helpdesk?useSSL=false&serverTimezone=UTC";

    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "AyV5z@^9sE";

    //Methods
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
