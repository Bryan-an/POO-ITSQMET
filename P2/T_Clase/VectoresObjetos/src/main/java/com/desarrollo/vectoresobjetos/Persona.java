/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.vectoresobjetos;

/**
 *
 * @author bryan
 */
public class Persona {

    private int idPersona;
    private String nombre;
    private int cedula;
    private static int contPersona;

    private Persona() {
        this.idPersona = ++contPersona;
    }

    public Persona(String nombre, int cedula) {
        this(); //llamar al constructor de la misma clase
        this.nombre = nombre;
        this.cedula = cedula;
    }

    //Getters and setters
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public static int getContPersona() {
        return contPersona;
    }

    public static void setContPersona(int contPersona) {
        Persona.contPersona = contPersona;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", cedula=" + cedula + '}';
    }

}
