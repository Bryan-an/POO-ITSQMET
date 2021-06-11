/*
 * Agua
 */
package com.desarrollo.examen;

/**
 * Creada por Bryan en 9/6/2021
 *
 * @author bryan
 */
public class Agua extends Bebida {

    //Fields
    private String marca;
    private static double precioTotal = 0;
    private static int contadorTesalia = 0;
    private static int contadorCielo = 0;
    private static int contadorNatura = 0;

    //Constructor
    /**
     * Constructor de la clase Agua
     *
     * @param tipoBotella Tipo de botella.
     * @param litros Cantidad de litros.
     * @param precio Precio de la bebida.
     * @param marca Marca de la bebida.
     */
    public Agua(String tipoBotella, double litros, double precio, String marca) {
        super(tipoBotella, litros, precio);
        this.marca = marca;
        calcularTotal();
        contarMarcas(marca);
    }

    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public static double getPrecioTotal() {
        return precioTotal;
    }

    public static void setPrecioTotal(double precioTotal) {
        Agua.precioTotal = precioTotal;
    }

    public static int getContadorTesalia() {
        return contadorTesalia;
    }

    public static void setContadorTesalia(int contadorTesalia) {
        Agua.contadorTesalia = contadorTesalia;
    }

    public static int getContadorCielo() {
        return contadorCielo;
    }

    public static void setContadorCielo(int contadorCielo) {
        Agua.contadorCielo = contadorCielo;
    }

    public static int getContadorNatura() {
        return contadorNatura;
    }

    public static void setContadorNatura(int contadorNatura) {
        Agua.contadorNatura = contadorNatura;
    }

    //Métodos
    /**
     * Método que calcula el total a pagar por las pacas de agua.
     */
    public void calcularTotal() {
        Agua.precioTotal += super.getPrecio();
    }

    /**
     * Método que cuente las marcas de las pacas de agua.
     *
     * @param marca Marca de la paca de agua.
     */
    public void contarMarcas(String marca) {
        switch (marca) {
            case "tesalia":
                contadorTesalia++;
                break;
            case "cielo":
                contadorCielo++;
                break;
            case "natura":
                contadorNatura++;
                break;
        }
    }

    @Override
    public String toString() {
        return "Agua{" + super.toString() + "; marca = " + marca + '}';
    }

}
