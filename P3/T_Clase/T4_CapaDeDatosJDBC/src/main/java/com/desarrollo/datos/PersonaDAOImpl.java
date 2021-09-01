/*
 * Clase DAO (Acceso a datos) que realiza las operaciones en la clase entidad.
 */
package com.desarrollo.datos;

import com.desarrollo.domain.PersonaDTO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Bryan Andagoya
 */
public class PersonaDAOImpl implements AccesoDatosDAO<PersonaDTO> {

    private static final String SQL_SELECT = "SELECT * FROM persona";

    private static final String SQL_INSERT
            = "INSERT INTO persona (nombre, apellido, edad, telefono, email) VALUES (?,?,?,?,?)";

    private static final String SQL_UPDATE
            = "UPDATE persona SET nombre=?, apellido=?, edad=?, telefono=?, email=? WHERE id_persona=?";

    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    //objeto de Connection
    private Connection conexionTransaccional = null;
    private static Connection conn = null;
    //objeto PreparedStatement
    private static PreparedStatement stmt = null;
    //objeto ResultSet
    private static ResultSet rs = null;

    //Definir constructor
    public PersonaDAOImpl(Connection conexionTransaccion) {
        this.conexionTransaccional = conexionTransaccion;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();

        try {
            if (this.conexionTransaccional != null) {
                conn = this.conexionTransaccional;
            } else {
                conn = Conexion.getConnection();
            }

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
                PersonaDTO persona = new PersonaDTO(idPersona, nombre, apellido, edad,
                        telefono, email);
                personas.add(persona);
            }
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);

                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }

    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        int registros = 0;

        try {
            if (this.conexionTransaccional != null) {
                conn = this.conexionTransaccional;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getTelefono());
            stmt.setString(5, persona.getEmail());

            //ejecutar query
            registros = stmt.executeUpdate();
        } finally {
            try {
                Conexion.close(stmt);

                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    //Método actualizar
    @Override
    public int update(PersonaDTO persona) throws SQLException {
        int registro = 0;

        try {
            if (this.conexionTransaccional != null) {
                conn = this.conexionTransaccional;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getTelefono());
            stmt.setString(5, persona.getEmail());
            //id-actualizar registro
            stmt.setInt(6, persona.getIdPersona());

            registro = stmt.executeUpdate();
        } finally {
            try {
                Conexion.close(stmt);

                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registro;
    }

    //método eliminar
    @Override
    public int delete(PersonaDTO persona) throws SQLException {
        int registro = 0;

        try {
            if (this.conexionTransaccional != null) {
                conn = this.conexionTransaccional;
            } else {
                conn = Conexion.getConnection();
            }
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, persona.getIdPersona());

            registro = stmt.executeUpdate();
        } finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registro;
    }
}
