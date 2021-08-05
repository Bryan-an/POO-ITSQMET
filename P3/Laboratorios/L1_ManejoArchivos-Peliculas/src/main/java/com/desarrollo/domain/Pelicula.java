/*
 * Manejo de archivos
 */
package com.desarrollo.domain;

/**
 *
 * @author Bryan Andagoya
 */
public class Pelicula {

    //Campos
    private String nombre;
    private String genero;
    private double precio;

    //Constructores
    public Pelicula() {
    }

    public Pelicula(String nombre, String genero, double precio) {
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
    }

    //get-set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString()
    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + ", genero=" + genero + ", precio=" + precio + '}';
        //return nombre + "," + genero + "," + precio;
    }

}
