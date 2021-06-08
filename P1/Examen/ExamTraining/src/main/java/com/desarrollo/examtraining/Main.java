/*
 * Exam training
 */
package com.desarrollo.examtraining;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Main {

    //Fields
    private Scanner sc = new Scanner(System.in);
    private final int PERISHABLE = 1;
    private final int NONPERISHABLE = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        showMenu();
    }

    public void showMenu() {
        int optionNumber;

        do {
            System.out.println("\n---------------Tipo de Producto---------------\n"
                    + "\n1. Perecedero"
                    + "\n2. No perecedero"
                    + "\n3. Salir\n"
                    + "\nDigite una opción:");
            optionNumber = sc.nextInt();
            sc.skip("\n");
            performOperations(optionNumber);
        } while (optionNumber != 3);
    }

    public void performOperations(int optionNumber) {
        switch (optionNumber) {
            case 1:
                askData(PERISHABLE);
                break;
            case 2:
                askData(NONPERISHABLE);
                break;
            case 3:
                System.out.println("\nGracias por utilizar nuestro programa");
                break;
            default:
                System.out.println("\nOpción inválida, intente de nuevo");
                ;
        }
    }

    public void askData(int type) {
        System.out.println("\nIngrese el nombre del producto:");
        String name = sc.nextLine();

        System.out.println("\nIngrese el precio del producto:");
        double price = sc.nextDouble();
        sc.skip("\n");

        switch (type) {
            case PERISHABLE:
                System.out.println("\nIngrese los días a caducar del producto:");
                int daysExpire = sc.nextInt();
                sc.skip("\n");
                Perishable perishable = new Perishable(name, price, daysExpire);
                perishable.calculatePrice();
                System.out.println(perishable);
                break;

            case NONPERISHABLE:
                System.out.println("\nIngrese el tipo del producto:");
                String typeProduct = sc.nextLine();
                Nonperishable nonperishable = new Nonperishable(name, price, typeProduct);
                System.out.println(nonperishable);
                break;
        }
    }

}
