/*
 * Trabajo en clase: recursividad
 */
package com.desarrollo.factorialnumero;

/**
 *
 * @author bryan
 */
public class Factorial {

//    public static void factorialNumero(int resultado, int factor, int numero) {
//        if ((numero != 0) && (numero != 1)) {
//            if (factor <= numero) {
//                System.out.print(factor);
//                if (factor != numero) {
//                    System.out.print(" x ");
//                }
//                resultado *= factor;
//                factorialNumero(resultado, factor + 1, numero);
//            } else {
//                System.out.println("\nResultado: " + resultado);
//            }
//        } else {
//            System.out.println("\nResultado: " + numero);
//        }
//    }
    private static int valorFactorial = 1;

    public static int factorial(int numero) {
        if (numero > 0) {
            valorFactorial = numero * factorial(numero - 1);
        }
        return valorFactorial;
    }

}
