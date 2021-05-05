/*
Encapsulamiento
 */
package com.desarrollo.encapsulamiento;

/**
 *
 * @author bryan
 */
public class Persona {

    //Atributos
    //Encapsulamiento - todos los atributos deben ser private
    private String nombre;
    private int edad;
    private double sueldo;

    //Constructor
    public Persona(String arg1, int arg2, double arg3) {
        nombre = arg1;
        edad = arg2;
        sueldo = arg3;
    }

    //Get's y Set's
    //Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Sueldo
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //Método toString

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + '}';
    }
    
}
