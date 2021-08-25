package com.desarrollo.data;

import com.desarrollo.domain.Employee;
import com.desarrollo.domain.EmployeeBuilder;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class EmployeeDAO {

    //Fields
    private EmployeeBuilder builder = new EmployeeBuilder();

    private static final String SQL_SELECT = "SELECT * FROM empleado";

    private static final String SQL_INSERT
            = "INSERT INTO empleado (nombre, apellido, sueldo, fecha_ingreso) VALUES (?,?,?,?)";

    //Methods
    public List<Employee> select() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = Connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
             ResultSet results = statement.executeQuery()) {

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
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return employees;
    }

    public int insert(Employee employee) {
        int records = 0;

        try (Connection connection = Connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getLastName());
            statement.setDouble(3, employee.getSalary());
            statement.setString(4, employee.getEntryDate().toString());

            records = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return records;
    }
}
