/*
Laboratorio 1
 */
package com.desarrollo.l1_caja;

import java.util.Scanner;

/**
 * Clase ejecutable
 *
 * @author bryan
 */
public class Main {

    //Campos
    private Caja caja;

    //Constructor
    /**
     * Constructor de la clase Main
     */
    public Main() {
        pedirDatos();
    }

    //Método main
    /**
     * Método main.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Main();
    }

    //Métodos
    /**
     * Método que pide las dimensiones de la caja.
     */
    public void pedirDatos() {
        double ancho, alto, profundidad;
        ancho = pedirMedida("\nDigite la medida del alto:");
        alto = pedirMedida("\nDigite la medida del ancho:");
        profundidad = pedirMedida("\nDigite la medida del largo:");
        caja = new Caja(alto, ancho, profundidad);
        System.out.println("\nEl volumen de la caja es: " + caja.calcularVolumen());
    }

    /**
     * Método que pide la dimensión de una medida
     *
     * @param pedido Pedido para el usuario.
     * @return La medida válida.
     */
    public double pedirMedida(String pedido) {
        boolean valido;
        Scanner sc = new Scanner(System.in);
        double medida = 0;

        do {
            valido = false;
            try {
                System.out.println(pedido);
                medida = sc.nextDouble();
                if (medida > 0) {
                    valido = true;
                } else {
                    System.out.println("\nMedida inválida");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("\nError: " + e.getMessage());
            }
        } while (!valido);

        return medida;
    }
}
