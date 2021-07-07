/*
 * Foreach
 */
package com.desarrollo.foreach;

/**
 * Creada el 7/7/2021
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableForeach {

    /**
     * Main thread.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] edades = {20, 21, 22, 23};

        //iteramos el arreglo
        System.out.println("Edades");
        for (int edad : edades) {
            System.out.println(edad);
        }

        //vector de objetos persona
        Persona[] personas = {new Persona("Monica", 21), new Persona("Bryan", 19)};

        //Iterar con el foreach
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
