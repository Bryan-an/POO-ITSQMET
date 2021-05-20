/*
 * Static
 */
package com.desarrollo.modificadorstatic;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class ClaseEjecutablePersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        nombre = sc.next();

        Persona persona = new Persona(nombre);
        System.out.println(persona);

        Persona persona2 = new Persona("Carlos");
        System.out.println(persona2);
    }

}
