/*
 * Establecer conexión con la base de datos y el cierre de conexión
 */
package com.desarrollo.datos;

import java.sql.*;

/**
 *
 * @author Bryan Andagoya
 */
public class Conexion {

    private static final String JDBC_URL
            = "jdbc:mysql://localhost:3306/desarrollo_itsqmet?useSSL=false&serverTimezone=UTC";

    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "AyV5z@^9sE";

    //método establecer la conexión a la BDD
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    //métodos cerrar conexiones
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
