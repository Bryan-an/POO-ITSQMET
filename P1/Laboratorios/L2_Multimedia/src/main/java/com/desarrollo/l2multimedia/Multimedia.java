/*
Laboratorio 2
 */
package com.desarrollo.l2multimedia;

import java.text.DecimalFormat;

/**
 *
 * @author bryan
 */
public class Multimedia {

    //Atributos
    private String titulo;
    private String autor;
    private String formato;
    private double precio;
    private int duracion;
    private DecimalFormat formateador = new DecimalFormat("0.00");

    //getters -setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    //Counstructor
    public Multimedia() {
    }

    public Multimedia(String titulo, String autor, String formato, double precio, int duracion) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.precio = precio;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "título = " + titulo + "; autor = " + autor + "; formato = " + formato + "; precio = $" + formateador.format(precio) + "; duración = " + duracion + " min";
    }

}
