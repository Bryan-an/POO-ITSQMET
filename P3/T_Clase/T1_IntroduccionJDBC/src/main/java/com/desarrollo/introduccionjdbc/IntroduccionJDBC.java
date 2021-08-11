/*
 * Introducción a JDBC
 */
package com.desarrollo.introduccionjdbc;

import java.sql.*;

/**
 *
 * @author Bryan Andagoya
 */
public class IntroduccionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Crear la cadena de conexión -> mysql
        String url = "jdbc:mysql://localhost:3306/desarrollo_itsqmet?useSSL=false&serverTimezone=UTC";

        try {
            //2. Crear el objeto de conexión a la BDD
            Connection conexion = DriverManager.getConnection(url, "root", "AyV5z@^9sE");
            //3. Crear el objeto Statement -> prepara las querys
            Statement query = conexion.createStatement();
            //4. Crear query
            String sql = "SELECT * FROM persona";
            //5. Ejecutar query -> objeto Resulset
            ResultSet resultado = query.executeQuery(sql);
            //6. Desplegar registros
            while (resultado.next()) {
                //System.out.println("ID: " + resultado.getInt("id_persona"));
                System.out.println("\nID: " + resultado.getInt(1)); //Tambien se puede especificar el índice de la columnna
                System.out.println("Nombre: " + resultado.getString(2));
                System.out.println("Apellido: " + resultado.getString(3));
                System.out.println("Edad: " + resultado.getInt(4));
                System.out.println("Teléfono: " + resultado.getInt(5));
                System.out.println("Correo: " + resultado.getString(6));
            }
            //7. Cerramos objetos creados
            resultado.close();
            query.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
