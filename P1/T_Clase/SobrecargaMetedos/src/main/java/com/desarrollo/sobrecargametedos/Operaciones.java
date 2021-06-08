/*
 * Sobrecarga de métodos
 */
package com.desarrollo.sobrecargametedos;

/**
 *
 * @author bryan
 */
public class Operaciones {

    public static int sumar(int num1, int num2) {
        System.out.println("Método 1: 2 argumentos(int)");
        return num1 + num2;
    }

    public static double sumar(double num1, double num2) {
        System.out.println("Método 2: 2 argumentos(double)");
        return num1 + num2;
    }

    public static long sumar(long num1, int num2) {
        System.out.println("Método 3: 2 argumentos(long, int)");
        return num1 + num2;
    }
}
