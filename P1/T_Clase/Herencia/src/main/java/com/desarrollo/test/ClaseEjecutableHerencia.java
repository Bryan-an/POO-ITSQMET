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
        int numeroOpcionPrincipal;
        int numeroOpcionEmpleado;
        int numeroOpcionCliente;
        int edad;
        int horasTrabajadas;
        double valorHora;
        char genero;
        String nombre;
        String direccion;
        String vip;

        Empleado empleado = null;
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);

        Empleado empleado1 = new Empleado();
        System.out.println(empleado1);
        Empleado empleado2 = new Empleado(80, 8.5);
        System.out.println(empleado2);

        do {

            System.out.println("HELPDESK");
            System.out.println("1. Empleado");
            System.out.println("2. Cliente");
            System.out.println("3. Salir");
            System.out.println("Escoja una opción: ");
            numeroOpcionPrincipal = sc.nextInt();
            sc.skip("\n");

            switch (numeroOpcionPrincipal) {
                case 1:
                    do {
                        System.out.println("\nAcciones"
                                + "\n1. Ingresar datos"
                                + "\n2. Visualizar datos"
                                + "\n3. Salir"
                                + "\nEscoja una opción: ");
                        numeroOpcionEmpleado = sc.nextInt();
                        sc.skip("\n");

                        switch (numeroOpcionEmpleado) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombre = sc.nextLine();
                                System.out.println("Género: ");
                                genero = sc.next().charAt(0);
                                System.out.println("Edad: ");
                                edad = sc.nextInt();
                                sc.skip("\n");
                                System.out.println("Dirección: ");
                                direccion = sc.nextLine();
                                System.out.println("Horas trabajadas: ");
                                horasTrabajadas = sc.nextInt();
                                sc.skip("\n");
                                System.out.println("Valor hora: ");
                                valorHora = sc.nextDouble();
                                empleado = new Empleado(nombre, genero, edad, direccion, horasTrabajadas, valorHora);
                                empleado1 = new Empleado();
                                break;

                            case 2:
                                System.out.println(empleado);
                                empleado.calcularSueldo();
                                break;
                            default:

                        }
                    } while (numeroOpcionEmpleado != 3);
                    break;

                case 2:
                    do {
                        System.out.println("\nAcciones"
                                + "\n1. Ingresar datos"
                                + "\n2. Visualizar datos"
                                + "\n3. Salir"
                                + "\nEscoja una opción: ");
                        numeroOpcionCliente = sc.nextInt();
                        sc.skip("\n");

                        switch (numeroOpcionCliente) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombre = sc.nextLine();
                                System.out.println("Género: ");
                                genero = sc.next().charAt(0);
                                System.out.println("Edad: ");
                                edad = sc.nextInt();
                                sc.skip("\n");
                                System.out.println("Dirección: ");
                                direccion = sc.nextLine();
                                System.out.println("VIP(si/no): ");
                                vip = sc.next();
                                cliente = new Cliente(nombre, genero, edad, direccion, vip);
                                break;
                            case 2:
                                System.out.println(cliente);
                                break;
                            default:

                        }
                    } while (numeroOpcionCliente != 3);

                    break;

                case 3:
                    System.out.println("Gracias por utilizar nuestro programa");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (numeroOpcionPrincipal != 3);

    }

}
