/*
Laboratorio 1
 */
package com.desarrollo.l1_caja;

/**
 * Clase Caja.
 *
 * @author bryan
 */
public class Caja {

    //Campos
    private double alto, ancho, profundidad;

    //Getter y Setters
    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    //Constructores
    public Caja() {
    }

    /**
     * Constructor de la clase Caja.
     *
     * @param alto Alto de la caja.
     * @param ancho Ancho de la caja.
     * @param profundidad Largo de la caja.
     */
    public Caja(double alto, double ancho, double profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    //Métodos
    /**
     * Método que calcula el volumen de la caja.
     *
     * @return El volumen de la caja.
     */
    public double calcularVolumen() {
        double volumen;
        volumen = alto * ancho * profundidad;
        return volumen;
    }
}
