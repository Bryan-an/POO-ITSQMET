/*
Clase ejecutable
 */
package com.desarrollo.introduccionpoo;

/**
 * Created by Bryan on 28/4/2021
 *
 * @author bryan
 */
public class ClaseEjecutablePersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Intanciar la clase Persona
        Persona pers1 = new Persona();
        pers1.nombre = "Bryan";
        pers1.edad = 20;
        pers1.genero = 'M';
        pers1.ocupacion = "Estudiante";

        //LLamar método
        pers1.informacionPersona();

        //Crear otro objeto de la clase Persona
        Persona pers2 = new Persona();
        pers2.nombre = "Andres";
        pers2.edad = 34;
        pers2.genero = 'M';
        pers2.ocupacion = "Doctor";

        System.out.println("");
        pers2.informacionPersona();
    }

}
