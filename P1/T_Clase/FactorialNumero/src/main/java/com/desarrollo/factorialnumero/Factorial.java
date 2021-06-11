/*
 * Trabajo en clase: recursividad
 */
package com.desarrollo.factorialnumero;

/**
 *
 * @author bryan
 */
public class Factorial {

    private static int valorFactorial = 1;

    public static int factorial(int numero) {
        if (numero > 0) {
            valorFactorial = numero * factorial(numero - 1);
        }
        return valorFactorial;
    }

}
