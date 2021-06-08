/*
 * Sobrecarga de métodos
 */
package com.desarrollo.sobrecargametedos;

/**
 *
 * @author bryan
 */
public class ClaseEjecutableOperaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Resultado: " + Operaciones.sumar(2, 5));
        System.out.println("Resultado: " + Operaciones.sumar(2.4, 5));
        System.out.println("Resultado: " + Operaciones.sumar(3L, 4));
        System.out.println("Resultado: " + Operaciones.sumar(3, 7L));

        //byte -> 8 bits
        //short -> 16 bits
        //int -> 32 bits
        //long -> 64 bits
        //float -> 32 bits 
        //double -> 64 bits
        //char -> 32 bits
    }

}
