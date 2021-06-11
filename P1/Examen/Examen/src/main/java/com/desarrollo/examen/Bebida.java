/*
 * Bebida
 */
package com.desarrollo.examen;

/**
 * Creado por Bryan en 9/6/2021
 *
 * @author bryan
 */
public class Bebida {

    //Fields
    private static int contadorBebidas = 0;
    private int identificador;
    private String tipoBotella;
    private double litros;
    private double precio;

    //Constructor
    public Bebida() {
    }

    /**
     * Constructor de la clase Bebida
     *
     * @param tipoBotella Tipo de botella.
     * @param litros Cantidad de litros.
     * @param precio Precio de la bebida.
     */
    public Bebida(String tipoBotella, double litros, double precio) {
        this.tipoBotella = tipoBotella;
        this.litros = litros;
        this.precio = precio;
        this.identificador = ++Bebida.contadorBebidas;
    }

    //Getters y setters
    public static int getContadorBebidas() {
        return contadorBebidas;
    }

    public static void setContadorBebidas(int contadorBebidas) {
        Bebida.contadorBebidas = contadorBebidas;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTipoBotella() {
        return tipoBotella;
    }

    public void setTipoBotella(String tipoBotella) {
        this.tipoBotella = tipoBotella;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Métodos
    @Override
    public String toString() {
        return "identificador = " + identificador + "; tipo de botella = "
                + tipoBotella + "; cantidad de litros = " + litros + " L; precio = $ "
                + (Math.round(precio * 100.0) / 100.0);
    }

}
