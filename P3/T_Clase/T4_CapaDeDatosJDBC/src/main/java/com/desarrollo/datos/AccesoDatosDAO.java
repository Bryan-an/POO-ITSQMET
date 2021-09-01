/*
 * Interfaz Persona DAO
 */
package com.desarrollo.datos;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Bryan Andagoya
 * @param <T>
 */
public interface AccesoDatosDAO<T> {

    //métodos abstractos
    public List<T> select() throws SQLException;

    public int insert(T objeto) throws SQLException;

    public int update(T objeto) throws SQLException;

    public int delete(T objeto) throws SQLException;
}
