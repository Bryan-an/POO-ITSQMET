/*
Modificador de acceso static
 */
package com.desarrollo.modificadorstatic;

/**
 *
 * @author bryan
 */
public class Persona {

    private int idPersona;
    private String nombre;
    //atributo estático
    private static int contPersonas = 0;

    //Constructor
    public Persona(String nombre) {
        idPersona = ++contPersonas;
        this.nombre = nombre;
    }

    //get-set
    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getContPersonas() {
        return contPersonas;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + '}';
    }

}
