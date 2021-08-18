/*
 * Clase DAO (Acceso a datos) que realiza las operaciones en la clase entidad.
 */
package com.desarrollo.datos;

import com.desarrollo.domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Andagoya
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT
            = "INSERT INTO persona (nombre, apellido, edad, telefono, email) VALUES (?,?,?,?,?)";

    //objeto de Connection
    private static Connection conn = null;
    //objeto PreparedStatement
    private static PreparedStatement stmt = null;
    //objeto ResultSet
    private static ResultSet rs = null;

    public List<Persona> select() {
        List<Persona> personas = new ArrayList<Persona>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                int edad = rs.getInt(4);
                int telefono = rs.getInt(5);
                String email = rs.getString(6);

                //crear objeto persona por cada registro
                Persona persona = new Persona(idPersona, nombre, apellido, edad,
                        telefono, email);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }

    public int insert(Persona persona) {
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getTelefono());
            stmt.setString(5, persona.getEmail());

            //ejecutar query
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }
}
