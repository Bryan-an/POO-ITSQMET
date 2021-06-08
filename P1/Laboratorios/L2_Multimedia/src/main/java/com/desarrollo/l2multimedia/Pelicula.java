/*
Laboratorio 2
 */
package com.desarrollo.l2multimedia;

/**
 *
 * @author bryan
 */
public class Pelicula extends Multimedia {

    //Atributos
    private String actor;

    //Get-Set
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    //Constructor
    public Pelicula(String titulo, String autor, String formato, double precio, int duracion, String actor) {
        super(titulo, autor, formato, precio, duracion);
        this.actor = actor;
    }

    //Métodos
    @Override
    public String toString() {
        return "Película: " + super.toString() + "; protagonista = " + actor;
    }

    public void descuento() {
        super.setPrecio(super.getPrecio() * 0.92);
    }
}
