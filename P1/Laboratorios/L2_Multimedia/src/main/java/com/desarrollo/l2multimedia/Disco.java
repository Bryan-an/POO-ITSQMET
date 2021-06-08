/*
Laboratorio
 */
package com.desarrollo.l2multimedia;

/**
 *
 * @author bryan
 */
public class Disco extends Multimedia {

    //Atributos
    private static int contadorDiscos;
    private int capacidad;

    //get-set
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public static int getContadorDiscos() {
        return contadorDiscos;
    }

    public static void setContadorDiscos(int contadorDiscos) {
        Disco.contadorDiscos = contadorDiscos;
    }

    //Constructor
    public Disco(String titulo, String autor, String formato, double precio, int duracion, int capacidad) {
        super(titulo, autor, formato, precio, duracion);
        this.capacidad = capacidad;
        Disco.contadorDiscos++;

        if (contadorDiscos == 3) {
            System.out.println("\nUsted ha ganado un disco gratis");
        }
    }

    //Métodos 
    @Override
    public String toString() {
        return "Disco: " + super.toString() + "; capacidad(MB) = " + capacidad + " MB";
    }

}
