/*
 * D2: Clases abstractas
 */
package com.desarrollo.test;

import com.desarrollo.customers.*;
import static input.AskData.*;
import java.util.*;

/**
 *
 * @author Bryan Andagoya
 */
public final class Main {

    //Fields
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private Scanner input = new Scanner(System.in);

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

        System.out.println("------------Deber 2: Clases Abstractas-----------");
        do {
            optionNumber = askInt("\n1. Agregar cliente"
                    + "\n2. Visualizar información de los clientes"
                    + "\n3. Salir"
                    + "\n\nEscoja una opción:");

            performOperations(optionNumber);
        } while (optionNumber != 3);
    }

    /**
     * Method that performs the operations.
     *
     * @param optionNumber The option number.
     */
    public void performOperations(int optionNumber) {
        switch (optionNumber) {
            case 1 ->
                addCustomer();
            case 2 ->
                displayCustomersData();
            case 3 ->
                System.out.println("\nGracias por utilizar nuestro programa");
            default ->
                System.out.println("\nOpción inválida");
        }
    }

    /**
     * Method that adds customers to the collection.
     */
    public void addCustomer() {

        Customer customer = null;
        boolean valid;

        //Ask for the name of the customer.
        System.out.println("\nNombre del cliente: ");
        String name = input.nextLine();

        //Ask for the identity number of the customer.
        long identityNumber;
        do {
            valid = true;

            identityNumber = askLong("\nNumero de cédula de identidad del cliente: ",
                    Main::verifyIdentityNumber,
                    "\nNúmero de cédula inválido, intente de nuevo");

            for (Customer c : customers) {
                if (c.getIdentityNumber() == identityNumber) {
                    System.out.println("\nEse número de cédula ya existe");
                    valid = false;
                    break;
                }
            }
        } while (!valid);

        //Ask for the customer type.
        String customerType = askString("\nTipo del cliente: ",
                c -> c.toUpperCase().equals("A") || c.toUpperCase().equals("B")
                || c.toUpperCase().equals("C"), "\nTipo inválido, intente de nuevo");

        //Ask for the total to pay of the customer.
        double totalToPay = askDouble("\nTotal a pagar del cliente: ",
                t -> t > 0, "\nEl total debe ser mayor que cero");

        switch (CustomerType.valueOf(customerType.toUpperCase())) {
            case A ->
                customer = new CustomerA(name, identityNumber, CustomerType.A,
                        totalToPay);
            case B ->
                customer = new CustomerB(name, identityNumber, CustomerType.B,
                        totalToPay);
            case C ->
                customer = new CustomerC(name, identityNumber, CustomerType.C,
                        totalToPay);
        }

        customers.add(customer);

        if (addMoreClients()) {
            addCustomer();
        } else {
            displayCustomersData();
        }
    }

    /**
     * Method that displays the customers data.
     */
    public void displayCustomersData() {
        if (customers.isEmpty()) {
            System.out.println("\nTodavía no hay ningún cliente registrado");
        } else {
            System.out.println();
            customers.forEach(Customer::applyDiscount);
            customers.forEach(System.out::println);
        }
    }

    /**
     * Method that verifies the identity number.
     *
     * @param identityNumber The identity number.
     * @return Returns true if the identity number is valid.
     */
    public static boolean verifyIdentityNumber(long identityNumber) {
        String aux = String.valueOf(identityNumber);
        return aux.toCharArray().length == 10 && identityNumber > 0;
    }

    /**
     * Method that ask if you want to add more customers.
     *
     * @return Returns true if the user answers yes.
     */
    public boolean addMoreClients() {
        String answer = askString("\n¿Desea ingresar más clientes? (s/n)",
                a -> a.toLowerCase().equals("s") || a.toLowerCase().equals("n"),
                "\nRespuesta inválida, intente de nuevo");

        return answer.equals("s");
    }
}
