/*
 * Sobreescritura de métodos
 */
package com.desarrollo.sobreescritura_metodos;

/**
 *
 * @author Bryan Andagoya
 */
public class Empleado {

    protected String nombre;
    protected double sueldo;

    //Constructor
    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    //método obtenerInformacion
    public String obtenerInformacion() {
        return "Nombre: " + nombre
                + "\nSueldo: " + sueldo;
    }

    //get-set
    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
