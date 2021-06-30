/*
 * L1: diseño de clases
 */
package ventas;

import com.sistemas.ventas.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public final class Tecnomega {

    //Fields
    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Order> orders = new ArrayList<Order>();

    //Constructor
    public Tecnomega() {
        displayMenu();
    }

    //Methods
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Tecnomega();
    }

    public void displayMenu() {
        int optionNumber;

        System.out.println("-------------Tecnomega-------------");

        do {
            System.out.println("\n1. Hacer pedido"
                    + "\n2. Calcular precio total del pedido"
                    + "\n3. Desplegar detalles del pedido"
                    + "\n4. Salir"
                    + "\n\nIngrese una opción:");
            optionNumber = sc.nextInt();

            performOperations(optionNumber);
        } while (optionNumber != 4);
    }

    public void performOperations(int optionNumber) {
        switch (optionNumber) {
            case 1 ->
                askDataComputer();
            case 2 ->
                calculateOrderTotal();
            case 3 ->
                displayOrderDetails();
            case 4 ->
                System.out.println("\nGracias por utilizar nuestro programa");
            default ->
                System.out.println("\nOpción inválida, intente de nuevo");
        }
    }

    public void askDataComputer() {
        Order order = new Order();

        do {
            System.out.println("\nIngrese la marca de la computadora:");
            String computerMake = sc.next();

            System.out.println("\n---------------Monitor---------------");
            System.out.println("\nIngrese la marca del monitor:");
            String monitorMake = sc.next();

            System.out.println("\nIngrese el tamaño del monitor (cm):");
            double monitorSize = sc.nextDouble();

            System.out.println("\nIngrese el precio del monitor ($):");
            double monitorPrice = sc.nextDouble();

            System.out.println("\n---------------Teclado---------------");
            System.out.println("\nIngrese el tipo de entrada del teclado:");
            String keyboardInputType = sc.next();

            System.out.println("\nIngrese la marca del teclado:");
            String keyboardMake = sc.next();

            System.out.println("\nIngrese el precio del teclado ($):");
            double keyboardPrice = sc.nextDouble();

            System.out.println("\n---------------Ratón---------------");
            System.out.println("\nIngrese el tipo de entrada del ratón:");
            String mouseInputType = sc.next();

            System.out.println("\nIngrese la marca del ratón:");
            String mouseMake = sc.next();

            System.out.println("\nIngrese el precio del ratón ($):");
            double mousePrice = sc.nextDouble();

            Monitor monitor = new Monitor(monitorMake, monitorSize, monitorPrice);
            Keyboard keyboard = new Keyboard(keyboardInputType, keyboardMake, keyboardPrice);
            Mouse mouse = new Mouse(mouseInputType, mouseMake, mousePrice);
            Computer computer = new Computer(computerMake, monitor, keyboard, mouse);

            order.addComputer(computer);

        } while (askMoreComputers(order));

    }

    public boolean askMoreComputers(Order order) {
        boolean wantMore = false;
        char optionCharacter;

        do {
            System.out.println("\n¿Desea comprar otra computadora? (s/n):");
            optionCharacter = sc.next().charAt(0);

            switch (optionCharacter) {
                case 'n' -> {
                    order.showOrder();
                    System.out.println("\nCosto tatal del pedido: $"
                            + (Math.round(order.discountOrder()
                                    * 100.0) / 100.0));
                    orders.add(order);
                }
                case 's' ->
                    wantMore = true;
                default ->
                    System.out.println("\nOpción inválida intente de nuevo");
            }
        } while (!(optionCharacter == 's' || optionCharacter == 'n'));

        return wantMore;
    }

    public void calculateOrderTotal() {
        if (orders.isEmpty()) {
            System.out.println("\nAún no se ha realizado ningún pedido");
        } else {
            System.out.println("\nIngrese el ID del pedido:");
            int orderID = sc.nextInt();

            if (orderID > 0 && orderID <= Order.getOrderCounter()) {
                orders.stream()
                        .filter(order -> order.getOrderID() == orderID)
                        .forEach(order
                                -> System.out.println("\nCosto tatal del pedido "
                                + orderID + ": $"
                                + (Math.round(((Order) order).discountOrder()
                                        * 100.0) / 100.0)));
            } else {
                System.out.println("\nNo existe");
            }
        }
    }

    public void displayOrderDetails() {
        if (orders.isEmpty()) {
            System.out.println("\nAún no se ha realizado ningún pedido");
        } else {
            System.out.println("\nIngrese el ID del pedido:");
            int orderID = sc.nextInt();

            if (orderID > 0 && orderID <= Order.getOrderCounter()) {
                orders.stream()
                        .filter(order -> order.getOrderID() == orderID)
                        .forEach(Order::showOrder);
            } else {
                System.out.println("\nNo existe");
            }
        }
    }
}
