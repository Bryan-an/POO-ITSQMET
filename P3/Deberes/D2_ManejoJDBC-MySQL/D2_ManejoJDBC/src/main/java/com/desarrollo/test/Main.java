package com.desarrollo.test;

import com.desarrollo.data.EmployeeDAO;
import com.desarrollo.domain.Employee;
import com.desarrollo.domain.EmployeeBuilder;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import static input.AskForData.*;

public class Main {

    //Fields
    private List<Employee> employees;
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private EmployeeBuilder builder = new EmployeeBuilder();

    //Main method
    public static void main(String[] args) {
        new Main().displayMenu();
    }

    //Methods
    public void displayMenu() {
        String request = "\n---------------Menú de operaciones----------------"
                + "\n1. Listar empleados"
                + "\n2. Insertar empleado"
                + "\n3. Salir"
                + "\n\nIngrese una opción: ";

        Predicate<Integer> filter = number -> number >= 1 && number <= 3;
        String errorMessage = "\nOpción inválida, intente de nuevo";
        int optionNumber;

        do {
            optionNumber = askForInt(request, filter, errorMessage);
            performOperations(optionNumber);
        } while (optionNumber != 3);
    }

    public void performOperations(int optionNumber) {
        switch (optionNumber) {
            case 1 -> listEmployees();
            case 2 -> insertEmployee();
            case 3 -> System.out.println("\nGracias por utilizar nuestro programa");
        }
    }

    public void listEmployees() {
        employees = employeeDAO.select();
        employees.forEach(System.out::println);
    }

    public void insertEmployee() {
        System.out.println("\n-------------Información empleado------------");
        String name = askForName("Nombre");
        String lastName = askForLastName("Apellido");
        double salary = askForSalary();
        LocalDate entryDate = askForEntryDate();

        builder.setName(name);
        builder.setLastName(lastName);
        builder.setSalary(salary);
        builder.setEntryDate(entryDate);
        Employee employee = builder.getEmployee();

        System.out.println("\nEl número de registros insertados es: "
                + employeeDAO.insert(employee));
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
