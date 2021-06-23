/*
 * Corrección del L1: Diseño de clases
 */
package com.desarrollo.test;

import com.desarrllo.ventas.*;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Tecnomega {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Orden orden = new Orden();
        int op;
        String marca;
        double precio;
        String marcaMonitor;
        double tamanio;
        String tipoEntrada;
        String marcaDispositivoEntrada;

        System.out.println("Bienvenido a Tecnomega");

        do {
            System.out.println("\n1. Comprar computadora");
            System.out.println("2. Detalle de la compra");
            System.out.println("3. Salir");
            System.out.println("Escoja una opción:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("\nInformación computadora");
                    System.out.println("Marca:");
                    marca = sc.next();
                    System.out.println("Precio:");
                    precio = sc.nextDouble();
                    //Crear objeto monitor
                    System.out.println("\n----------Monitor---------");
                    System.out.println("Marca:");
                    marcaMonitor = sc.next();
                    System.out.println("Tamaño (cm):");
                    tamanio = sc.nextDouble();
                    Monitor monitor = new Monitor(marcaMonitor, tamanio);
                    //Crear objeto teclado
                    System.out.println("\n----------Teclado---------");
                    System.out.println("Tipo de entrada:");
                    tipoEntrada = sc.next();
                    System.out.println("Marca:");
                    marcaDispositivoEntrada = sc.next();
                    Teclado teclado = new Teclado(tipoEntrada, marcaDispositivoEntrada);
                    //Crear objeto ratón
                    System.out.println("\n----------Ratón---------");
                    System.out.println("Tipo de entrada:");
                    tipoEntrada = sc.next();
                    System.out.println("Marca:");
                    marcaDispositivoEntrada = sc.next();
                    Raton raton = new Raton(tipoEntrada, marcaDispositivoEntrada);
                    //Crear objeto clase Computadora
                    Computadora computadora = new Computadora(marca, precio, monitor, teclado, raton);
                    orden.agregarComputadora(computadora);
                    break;
                case 2:
                    orden.mostrarOrden();
                    break;
                case 3:
                    System.out.println("\nGracias por utilizar nuestro programa");
                    break;
                default:
                    System.out.println("\nOpción inválida");
            }
        } while (op != 3);
    }

}
