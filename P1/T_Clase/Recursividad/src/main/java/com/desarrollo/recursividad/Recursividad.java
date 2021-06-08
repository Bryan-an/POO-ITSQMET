/*
 * Recursividad
 */
package com.desarrollo.recursividad;

/**
 *
 * @author bryan
 */
public class Recursividad {

    //Realizar un programa que permite imprimir del 1 al 6
    public static void imprimir(int x) {
        if (x <= 6) {
            System.out.println("X: " + x);
            x++;

            imprimir(x);
        }
    }
}
