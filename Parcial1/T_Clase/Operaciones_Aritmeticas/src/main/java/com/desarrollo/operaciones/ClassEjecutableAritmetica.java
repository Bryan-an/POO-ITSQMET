/*
Class with the main method
 */
package com.desarrollo.operaciones;

import java.util.Scanner;

/**
 * Created by Bryan on 28/04/2021
 * 
 * @author bryan
 */
public class ClassEjecutableAritmetica {

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        //Instanciar la clase
        Aritmetica operaciones = new Aritmetica();
        //Llamar métodos
        //Método void
        operaciones.sumaVoid(8, 7);

        //Método return
        System.out.println("La suma es: " + operaciones.sumaReturn(5, 4));

        double resultado = operaciones.sumaReturn(7, 3); //Capturar lo que el método retorna en una variable. Se recomienda cuando se va a realizar otras operaciones con ese valor
        System.out.println("La suma es (variable): " + (resultado + 20)); //Mandar a imprimir la variable
        
        operaciones.sumaVoid(operaciones.sumaReturn(7, 3), 7);
        
        //Pedir datos
        Scanner sc = new Scanner(System.in);
        double num1, num2;
        
        System.out.println("INGRESO DATOS");
        System.out.println("Número 1: ");
        num1 = sc.nextDouble();
        System.out.println("Número 2: ");
        num2 = sc.nextDouble();
        
        operaciones.sumaVoid(num1, num2);
        operaciones.resta(num1, num2);
    }
}
