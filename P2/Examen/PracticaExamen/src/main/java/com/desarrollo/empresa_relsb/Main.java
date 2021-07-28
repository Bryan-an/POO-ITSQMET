/*
 * Ejercicio de practica empresa RelsB
 */
package com.desarrollo.empresa_relsb;

import static input.AskData.*;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Bryan Andagoya
 */
public final class Main {

    //Fields
    private ArrayList<Client> clients = new ArrayList<Client>();

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
        String request = "\n1. Ingresar cliente"
                + "\n2. Ver información de los clientes"
                + "\n3. Salir"
                + "\n\nDigite una opción:";

        Predicate<Integer> filter = number -> number >= 1 && number <= 3;
        String errorMessage = "\nOpción inválida, intente de nuevo";

        System.out.println("------------------Empresa RelsB------------------");

        do {
            optionNumber = askInt(request, filter, errorMessage);
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
                addClient();
            case 2 ->
                showClientsData();
            case 3 ->
                System.out.println("\nGracias por utilizar nuestro programa");
        }
    }

    /**
     * Method that adds a client to the client list.
     */
    public void addClient() {
        clients.add(askForClientData());

        if (addMoreClients()) {
            addClient();
        }
    }

    /**
     * Method that asks for the client data.
     *
     * @return The Client instance.
     */
    public Client askForClientData() {
        //Name
        String nameRequest = "\nIngrese el nombre del cliente:";
        Predicate<String> nameFilter = name -> name.matches("[a-zA-Z\\s]+");
        String nameErrorMessage = "\nNombre inválido, intente de nuevo";

        //Identification
        String idRequest
                = "\nIngrese el número de cédula del cliente:";

        Predicate<String> idFilter = id -> id.matches("[0-9]{10}");
        String idErrorMessage
                = "\nNúmero de cédula inválido, intente de nuevo";

        //Client Type
        String clientTypeRequest = "\nIngrese el tipo del cliente:";
        Predicate<String> clientTypeFilter = type -> type.matches("[ABCabc]");
        String clientTypeErrorMessage
                = "\nTipo de cliente inválido, intente de nuevo";

        //Bill
        String billRequest = "\nIngrese el total a pagar por la compra:";
        Predicate<Double> billFilter = b -> b > 0;
        String billErrorMessage = "\nValor inválido, intente de nuevo";

        //Ask for data
        String name = askString(nameRequest, nameFilter, nameErrorMessage);
        String identification = askString(idRequest, idFilter, idErrorMessage);
        ClientType clientType = ClientType.valueOf(askString(clientTypeRequest,
                clientTypeFilter, clientTypeErrorMessage).toUpperCase());

        double bill = askDouble(billRequest, billFilter, billErrorMessage);

        //Create client
        switch (clientType) {
            case A -> {
                return new ClientA(name, identification, clientType, bill);
            }
            case B -> {
                return new ClientB(name, identification, clientType, bill);
            }
            case C -> {
                return new ClientC(name, identification, clientType, bill);
            }
        }

        return null;
    }

    /**
     * Method that checks if the user wants to add more clients.
     *
     * @return The given answer.
     */
    public boolean addMoreClients() {
        String request = "\n¿Desea ingresar otro cliente? (s/n)";
        Predicate<String> filter = a -> a.matches("[snSN]");
        String errorMessage = "\nRespuesta inválida, intente de nuevo";

        String answer = askString(request, filter, errorMessage).toLowerCase();

        return answer.equals("s");
    }

    /**
     * Method that shows the clients data.
     */
    public void showClientsData() {
        if (clients.isEmpty()) {
            System.out.println("\nTodavía no se ha ingresado ningún cliente");
        } else {
            System.out.println("\n--------Información de los clientes-----------\n");
            clients.forEach(System.out::println);
        }
    }

}
