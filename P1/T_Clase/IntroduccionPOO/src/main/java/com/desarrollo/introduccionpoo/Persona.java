/*
Class 1
 */
package com.desarrollo.introduccionpoo;

/**
 *
 * @author bryan
 */
public class Persona {

    //atributos
    String nombre;
    char genero;
    int edad;
    String ocupacion;

    //métodos - void
    public void informacionPersona() {   //void --> no retorna ningún valor. El método no recibe parámetros
        System.out.println("INFORMACIÓN PERSONA");
        System.out.println("Nombre: " + nombre + "\n"
                + "Genero: " + genero + "\n"
                + "Edad: " + edad + "\n"
                + "Ocupación: " + ocupacion);
    }

}
