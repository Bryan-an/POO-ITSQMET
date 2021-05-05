/*
Class with the main method
 */
package com.desarrollo.operaciones;

import java.util.Scanner;

/**
 * Created by Bryan on 28/04/2021
 *
 * @author bryan
 */
public class ClassEjecutableAritmetica {

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {

        //Pedir datos
        Scanner sc = new Scanner(System.in);
        int op;

        //Menú
        do {
            System.out.println("\nMenú operaciones:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.println("Escoja una opción: ");
            op = sc.nextInt();

            if (op >= 1 && op <= 4) {
                double num1, num2;
                System.out.println("INGRESO DATOS");
                System.out.println("Número 1: ");
                num1 = sc.nextDouble();
                System.out.println("Número 2: ");
                num2 = sc.nextDouble();

                //Instanciar la clase
                Aritmetica operaciones = new Aritmetica(num1, num2);

                switch (op) {
                    case 1:
                        operaciones.sumaVoid();
                        break;
                    case 2:
                        operaciones.resta();
                        break;
                    case 3:
                        operaciones.multiplicacion();
                        break;
                    case 4:
                        operaciones.division();
                        break;
                }
            } else if (op == 5) {
                System.out.println("El programa se ha finalizado correctamente");
            } else {
                System.out.println("Opción inválida");
            }

        } while (op != 5);

        //Llamar métodos
    }
}
