/*
Herencia en Java
 */
package com.desarrollo.test;

import com.desarrollo.herencia.Cliente;
import com.desarrollo.herencia.Empleado;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class ClaseEjecutableHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op, opE, opC;
        String nombre, direccion, vip;
        char genero;
        int edad, horasT;
        double valorH;
        Empleado empleado = null;
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("HELPDESK");
            System.out.println("1. Empleado");
            System.out.println("2. Cliente");
            System.out.println("3. Salir");
            System.out.println("Escoja una opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    do {
                        System.out.println("\nAcciones\n1. Ingresar datos\n2. Visualizar datos\n3. Salir\nEscoja una opción: ");
                        opE = sc.nextInt();

                        switch (opE) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombre = sc.next();
                                System.out.println("Género: ");
                                genero = sc.next().charAt(0);
                                System.out.println("Edad: ");
                                edad = sc.nextInt();
                                System.out.println("Dirección: ");
                                direccion = sc.next();
                                System.out.println("Horas trabajadas: ");
                                horasT = sc.nextInt();
                                System.out.println("Valor hora: ");
                                valorH = sc.nextDouble();
                                empleado = new Empleado(nombre, genero, edad, direccion, horasT, valorH);
                                break;

                            case 2:
                                System.out.println(empleado);
                                empleado.calcularSueldo();
                                break;
                            default:

                        }
                    } while (opE != 3);
                    break;

                case 2:
                    do {
                        System.out.println("\nAcciones\n1. Ingresar datos\n2. Visualizar datos\n3. Salir\nEscoja una opción: ");
                        opC = sc.nextInt();

                        switch (opC) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombre = sc.next();
                                System.out.println("Género: ");
                                genero = sc.next().charAt(0);
                                System.out.println("Edad: ");
                                edad = sc.nextInt();
                                System.out.println("Dirección: ");
                                direccion = sc.next();
                                System.out.println("VIP(si/no): ");
                                vip = sc.next();
                                cliente = new Cliente(nombre, genero, edad, direccion, vip);
                                break;
                            case 2:
                                System.out.println(cliente);
                                break;
                            default:

                        }
                    } while (opC != 3);

                    break;

                case 3:
                    System.out.println("Gracias por utilizar nuestro programa");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (op != 3);

    }

}
