/**
 * Created by Bryan on 28/04/2021
 */
package com.desarrollo.deber1_arithmeticoperations;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class MainClass {

    //Variables and Instances
    private static double num1, num2;
    private static byte optionNumber;
    private static Scanner sc = new Scanner(System.in);

    /**
     * Main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean exit;
        do {
            exit = false;
            displayMenu();
            switch (optionNumber) {
                case 1:
                    System.out.println(Operations.addNumbers(num1, num2));
                    ;
                    break;
                case 2:
                    System.out.println(Operations.subtractNumbers(num1, num2));
                    break;
                case 3:
                    System.out.println(Operations.multiplyNumbers(num1, num2));
                    break;
                case 4:
                    System.out.println(Operations.divideNumbers(num1, num2));
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Dicha opción no existe, elija otra");
            }
        } while (!exit);

    }

    /**
     * Method that displays the menu.
     */
    public static void displayMenu() {
        System.out.println("\n-----------------OPERACIONES ARITMÉTICAS-----------------\n");
        System.out.println("¿Qué operación desea realizar?\n1. Suma\n2. Resta\n3. Multiplicación\n4. División\n5. Salir");
        optionNumber = sc.nextByte();
        if (optionNumber >= 1 && optionNumber <= 4) {
            System.out.println("\nIngrese el primer número:");
            num1 = sc.nextDouble();
            System.out.println("\nIngrese el segundo número:");
            num2 = sc.nextDouble();
        }
    }

}
