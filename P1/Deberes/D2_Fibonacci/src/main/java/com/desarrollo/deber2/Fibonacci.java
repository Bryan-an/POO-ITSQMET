/*
 * Fibonacci
 */
package com.desarrollo.deber2;

/**
 *
 * @author bryan
 */
public class Fibonacci {

    public static void serieFibonacci(int valorAnterior1, int valorAnterior2) {
        int numero = valorAnterior1 + valorAnterior2;
        String aux = numero + "";

        if (aux.length() <= 10) {
            System.out.println(numero);

            serieFibonacci(numero, valorAnterior1);
        }
    }

}
