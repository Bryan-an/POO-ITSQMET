/*
Paso por valor
 */
package com.desarrollo.pasovalor;

/**
 *
 * @author bryan
 */
public class PasoPorValor {

    public static void main(String[] args) {
        int x = 10;
        System.out.println("El valor de x es: " + x); //x: 10
        cambiarValor(x); //Está pasando el valor de la variable, no la variable en sí
        System.out.println("El nuevo valor de x es: " + x); //x: 10
    }

    public static void cambiarValor(int x) {
        System.out.println("Parámetro: " + x); //argX: 10
        x = 200;
        System.out.println("Parámetro modificado: " + x); //argX: 200
    }
}
