package com.desarrollo.test;

import com.desarrollo.data.Connect;
import com.desarrollo.data.EmployeeDAO;
import com.desarrollo.domain.Employee;
import com.desarrollo.domain.EmployeeBuilder;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import static input.AskForData.*;
import java.sql.*;

public class Main {

    //Fields
    private List<Employee> employees;

    private EmployeeBuilder employeeBuilder = new EmployeeBuilder();
    private Connection transactionalConnection = null;
    EmployeeDAO employeeDAO;

    //Main method
    public static void main(String[] args) {
        new Main().displayMenu();
    }

    //Methods
    public void displayMenu() {
        String request = "\n---------------Menú de operaciones----------------"
                + "\n1. Listar empleados"
                + "\n2. Insertar empleado"
                + "\n3. Actualizar empleado"
                + "\n4. Eliminar empleado"
                + "\n5. Salir"
                + "\n\nIngrese una opción: ";

        Predicate<Integer> filter = number -> number >= 1 && number <= 5;
        String errorMessage = "\nOpción inválida, intente de nuevo";
        int optionNumber;

        try {
            transactionalConnection = Connect.getConnection();

            if (transactionalConnection.getAutoCommit()) {
                transactionalConnection.setAutoCommit(false);
            }

            employeeDAO = new EmployeeDAO(transactionalConnection);

            do {
                optionNumber = askForInt(request, filter, errorMessage);
                performOperations(optionNumber);
            } while (optionNumber != 5);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

            try {
                System.out.println("ROLLBACK - BDD");
                transactionalConnection.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public void performOperations(int optionNumber) throws SQLException {
        switch (optionNumber) {
            case 1 ->
                listEmployees();
            case 2 ->
                insertEmployee();
            case 3 ->
                updateEmployee();
            case 4 ->
                deleteEmployee();
            case 5 -> {
                System.out.println("\nGracias por utilizar nuestro programa");
                transactionalConnection.commit();
            }
        }
    }

    public void listEmployees() throws SQLException {
        employees = employeeDAO.select();
        employees.forEach(System.out::println);
    }

    public void insertEmployee() throws SQLException {
        System.out.println("\n-------------Información empleado------------");
        String name = askForName("Nombre");
        String lastName = askForLastName("Apellido");
        double salary = askForSalary();
        LocalDate entryDate = askForEntryDate();

        employeeBuilder.setName(name);
        employeeBuilder.setLastName(lastName);
        employeeBuilder.setSalary(salary);
        employeeBuilder.setEntryDate(entryDate);
        Employee employee = employeeBuilder.getEmployee();

        System.out.println("\nEl número de registros insertados es: "
                + employeeDAO.insert(employee));
    }

    public void updateEmployee() throws SQLException {
        int id = askForId("\nIngrese el ID del empleado a actualizar: ");

        System.out.println("\n-------------------------------------------------"
                + "Información a actualizar");

        String name = askForName("Nombre");
        String lastName = askForLastName("Apellido");
        double salary = askForSalary();
        LocalDate entryDate = askForEntryDate();

        employeeBuilder.setId(id);
        employeeBuilder.setName(name);
        employeeBuilder.setLastName(lastName);
        employeeBuilder.setSalary(salary);
        employeeBuilder.setEntryDate(entryDate);
        Employee employee = employeeBuilder.getEmployee();

        System.out.println("\nEl número de registros actualizados es: "
                + employeeDAO.update(employee));
    }

    public void deleteEmployee() throws SQLException {
        int id = askForId("\nIngrese el id del empleado a eliminar: ");

        employeeBuilder.setId(id);
        Employee employee = employeeBuilder.getEmployee();

        System.out.println("\nEl número de registros eliminados es: "
                + employeeDAO.delete(employee));
    }

    public int askForId(String request) {
        Predicate<Integer> filter = id -> id >= 1;
        String errorMessage = "\nEl ID del empleado debe ser >= 1";

        return askForInt(request, filter, errorMessage);
    }

    public String askForName(String datum) {
        String request = "\n" + datum + ": ";
        Predicate<String> filter = s -> s.matches("\\D+");
        String errorMessage = "\n" + datum + " inválido, intente de nuevo";

        return askForString(request, filter, errorMessage);
    }

    public String askForLastName(String datum) {
        return askForName(datum);
    }

    public double askForSalary() {
        String request = "\nSueldo: ";
        Predicate<String> filter = n -> n.matches("\\d{1,6}(\\.\\d{1,2})?");
        String errorMessage = "\nSueldo inválido, intente de nuevo";

        return Double.parseDouble(askForString(request, filter, errorMessage));
    }

    public LocalDate askForEntryDate() {
        LocalDate entryDate = null;
        boolean validDate = false;

        do {
            System.out.println("\nFecha de ingreso:");
            int day = askForInt("\nDía: ");
            int month = askForInt("\nMes: ");
            int year = askForInt("\nAño: ");

            try {
                entryDate = LocalDate.of(year, month, day);
                validDate = true;
            } catch (DateTimeException ex) {
                System.out.println("\nFecha inválida, intente de nuevo");
            }
        } while (!validDate);

        return entryDate;
    }

}
