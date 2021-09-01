/*
 * Data access
 */
package com.desarrollo.data;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Bryan Andagoya
 * @param <T> Entity class
 */
public interface DataAccessDAO<T> {

    public List<T> select() throws SQLException;

    public int insert(T entity) throws SQLException;

    public int update(T entity) throws SQLException;

    public int delete(T entity) throws SQLException;
}
