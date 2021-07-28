/*
 * Examen P2
 */
package com.desarrollo.test;

import com.desarrollo.examen.*;
import static input.AskData.*;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Bryan Andagoya
 */
public final class Main {

    //Fields
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    /**
     * Main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().displayMenu();
    }

    /**
     * Method that displays the menu.
     */
    public void displayMenu() {
        int optionNumber;
        String request = "\n1. Registrar docente"
                + "\n2. Desplegar lista de docentes administrativos"
                + "\n3. Desplegar lista de docentes por horas"
                + "\n4. Desplegar cantidad de docentes administrativos con descuento"
                + "\n5. Desplegar cantidad de docentes por horas con descuento"
                + "\n6. Salir"
                + "\n\nDigite una opción: ";

        Predicate<Integer> filter = n -> n >= 1 && n <= 6;
        String errorMessage = "\nOpción inválida, intente de nuevo";

        System.out.println("\n----------Examen Segundo Parcial-----------");

        do {
            optionNumber = askInt(request, filter, errorMessage);
            performOperations(optionNumber);
        } while (optionNumber != 6);
    }

    /**
     * Method that performs the operations.
     *
     * @param optionNumber The option number.
     */
    public void performOperations(int optionNumber) {
        switch (optionNumber) {
            case 1 ->
                addTeacher();
            case 2 ->
                displayAdministrativeTeachersList();
            case 3 ->
                displayHourlyTeachersList();
            case 4 ->
                displayAdministrativeTeachersWithDiscount();
            case 5 ->
                displayHourlyTeachersWithDiscount();
            case 6 ->
                System.out.println("\nGracias por utilizar nuestro programa");
        }
    }

    /**
     * Method that adds a teacher.
     */
    public void addTeacher() {
        teachers.add(createTeacher());

        if (addMore()) {
            addTeacher();
        } else {
            displayAdministrativeTeachersList();
            displayHourlyTeachersList();
            displayAdministrativeTeachersWithDiscount();
            displayHourlyTeachersWithDiscount();
        }
    }

    /**
     * Method that creates a Teacher instance.
     *
     * @return The Teacher instance.
     */
    public Teacher createTeacher() {
        String name = askForName();
        String lastname = askForLastname();
        String idNumber = askForIdNumber();
        TeacherType type = TeacherType.valueOf(askForType());
        double hoursWorked = askForHoursWorked();

        switch (type) {
            case A -> {
                return new AdministrativeTeacher(name, lastname, idNumber, type,
                        hoursWorked);
            }
            case H -> {
                return new HourlyTeacher(name, lastname, idNumber, type,
                        hoursWorked);
            }
        }

        return null;
    }

    /**
     * Method that asks for the teacher's name.
     *
     * @return The teacher's name.
     */
    public String askForName() {
        String request = "\nIngrese el nombre del docente: ";
        Predicate<String> filter = s -> s.matches("[a-zA-Z]+");
        String ErrorMessage = "\nNombre inválido, intente de nuevo";

        return askString(request, filter, ErrorMessage);
    }

    /**
     * Method that asks for the teacher's lastname.
     *
     * @return The teacher's lastname.
     */
    public String askForLastname() {
        String request = "\nIngrese el apellido del docente: ";
        Predicate<String> filter = s -> s.matches("[a-zA-Z]+");
        String ErrorMessage = "\nApellido inválido, intente de nuevo";

        return askString(request, filter, ErrorMessage);
    }

    /**
     * Method that asks for the teacher's id number.
     *
     * @return The teacher's id number.
     */
    public String askForIdNumber() {
        String request = "\nIngrese la cédula del docente: ";
        Predicate<String> filter = s -> s.matches("[0-9]{10}")
                && !teachers.stream()
                        .anyMatch(t -> t.getIdNumber()
                        .equals(s));

        String ErrorMessage
                = "\nEl número de cédula es inválido o ya se encuentra registrado, intente de nuevo";

        return askString(request, filter, ErrorMessage);
    }

    /**
     * Method that asks for the teacher's type.
     *
     * @return The teacher's type.
     */
    public String askForType() {
        String request = "\nIngrese el tipo del docente (A/H): ";
        Predicate<String> filter = s -> s.matches("[ahAH]");
        String ErrorMessage = "\nTipo de docente inválido, intente de nuevo";

        return askString(request, filter, ErrorMessage).toUpperCase();
    }

    /**
     * Method that asks for the hours worded by the teacher.
     *
     * @return The hours worded by the teacher.
     */
    public double askForHoursWorked() {
        String request = "\nIngrese las horas trabajadas del docente: ";
        Predicate<Integer> filter = n -> n > 0;
        String ErrorMessage = "\nSueldo inválido, intente de nuevo";

        return askInt(request, filter, ErrorMessage);
    }

    /**
     * Method that asks user if he wants to add more teachers.
     *
     * @return The true if the user answers 's'.
     */
    public boolean addMore() {
        String request = "\n¿Desea ingresar más docentes?(s/n)";
        Predicate<String> filter = s -> s.matches("[snSN]");
        String errorMessage = "\nRepuesta inválida, intente de nuevo";

        return askString(request, filter, errorMessage).toLowerCase()
                .equals("s");
    }

    /**
     * Method that displays the administrative teachers list.
     */
    public void displayAdministrativeTeachersList() {
        if (teachers.stream()
                .filter(s -> s.getType() == TeacherType.A)
                .count() == 0) {

            System.out.println("\nAún no se registra ningun docente administrativo");
        } else {
            System.out.println("\nLista de docentes administrativos:\n");

            teachers.stream()
                    .filter(s -> s.getType() == TeacherType.A)
                    .forEach(System.out::println);
        }
    }

    /**
     * Method that displays the hourly teachers list.
     */
    public void displayHourlyTeachersList() {
        if (teachers.stream()
                .filter(s -> s.getType() == TeacherType.H)
                .count() == 0) {

            System.out.println("\nAún no se registra ningun docente por horas");
        } else {
            System.out.println("\nLista de docentes por horas:\n");

            teachers.stream()
                    .filter(s -> s.getType() == TeacherType.H)
                    .forEach(System.out::println);
        }
    }

    /**
     * Method that displays the amount of administrative teachers with discount.
     */
    public void displayAdministrativeTeachersWithDiscount() {
        if (AdministrativeTeacher.getTeachersWithDiscount() == 0) {
            System.out.println("\nNo hay ningún docente administrativo con descuento");
        } else {
            System.out.println("\nHay "
                    + AdministrativeTeacher.getTeachersWithDiscount()
                    + " docente/s administrativo/s con descuento");
        }
    }

    /**
     * Method that displays the amount of hourly teachers with discount.
     */
    public void displayHourlyTeachersWithDiscount() {
        if (HourlyTeacher.getTeachersWithDiscount() == 0) {
            System.out.println("\nNo hay ningún docente por horas con descuento");
        } else {
            System.out.println("\nHay "
                    + HourlyTeacher.getTeachersWithDiscount()
                    + " docente/s por horas con descuento");
        }
    }
}
