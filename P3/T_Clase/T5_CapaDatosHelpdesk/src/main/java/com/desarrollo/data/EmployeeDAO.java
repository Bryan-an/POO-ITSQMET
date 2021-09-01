package com.desarrollo.data;

import com.desarrollo.domain.EmployeeDTO;
import com.desarrollo.domain.EmployeeBuilder;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class EmployeeDAO implements DataAccessDAO<EmployeeDTO> {

    //Fields
    private EmployeeBuilder builder = new EmployeeBuilder();

    //SQL Statements
    private static final String SQL_SELECT = "SELECT * FROM empleado";

    private static final String SQL_INSERT
            = "INSERT INTO empleado (nombre, apellido, sueldo, fecha_ingreso) VALUES (?,?,?,?)";

    private static final String SQL_UPDATE
            = "UPDATE empleado SET nombre=?, apellido=?, sueldo=?, fecha_ingreso=? WHERE id_empleado=?";

    private static final String SQL_DELETE
            = "DELETE FROM empleado WHERE id_empleado=?";

    //Connections
    private Connection transactionalConnection = null;
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet results = null;

    public EmployeeDAO(Connection transactionalConnection) {
        this.transactionalConnection = transactionalConnection;
    }

    //Methods
    @Override
    public List<EmployeeDTO> select() throws SQLException {
        List<EmployeeDTO> employees = new ArrayList<>();

        try {
            if (transactionalConnection != null) {
                connection = transactionalConnection;
            } else {
                connection = Connect.getConnection();
            }

            statement = connection.prepareStatement(SQL_SELECT);
            results = statement.executeQuery();

            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String lastName = results.getString(3);
                double salary = results.getDouble(4);
                LocalDate entryDate = LocalDate.parse(results.getString(5));

                builder.setId(id);
                builder.setName(name);
                builder.setLastName(lastName);
                builder.setSalary(salary);
                builder.setEntryDate(entryDate);

                employees.add(builder.getEmployee());
            }
        } finally {
            try {
                results.close();
                statement.close();

                if (transactionalConnection == null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return employees;
    }

    @Override
    public int insert(EmployeeDTO employee) throws SQLException {
        int records = 0;

        try {
            if (transactionalConnection != null) {
                connection = transactionalConnection;
            } else {
                connection = Connect.getConnection();
            }

            statement = connection.prepareStatement(SQL_INSERT);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getLastName());
            statement.setDouble(3, employee.getSalary());
            statement.setString(4, employee.getEntryDate().toString());

            records = statement.executeUpdate();
        } finally {
            try {
                statement.close();

                if (transactionalConnection == null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return records;
    }

    @Override
    public int update(EmployeeDTO employee) throws SQLException {
        int records = 0;

        try {
            if (transactionalConnection != null) {
                connection = transactionalConnection;
            } else {
                connection = Connect.getConnection();
            }

            statement = connection.prepareStatement(SQL_UPDATE);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getLastName());
            statement.setDouble(3, employee.getSalary());
            statement.setString(4, employee.getEntryDate().toString());
            statement.setInt(5, employee.getId());

            records = statement.executeUpdate();
        } finally {
            try {
                statement.close();

                if (transactionalConnection == null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return records;
    }

    @Override
    public int delete(EmployeeDTO employee) throws SQLException {
        int records = 0;

        try {
            if (transactionalConnection != null) {
                connection = transactionalConnection;
            } else {
                connection = Connect.getConnection();
            }

            statement = connection.prepareStatement(SQL_DELETE);

            statement.setInt(1, employee.getId());

            records = statement.executeUpdate();
        } finally {
            try {
                statement.close();

                if (transactionalConnection == null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return records;
    }
}
