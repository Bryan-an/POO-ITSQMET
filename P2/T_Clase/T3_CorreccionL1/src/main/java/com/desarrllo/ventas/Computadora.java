/*
 * Corrección del L1: Diseño de clases
 */
package com.desarrllo.ventas;

/**
 *
 * @author bryan
 */
public class Computadora {

    private static int contComputadora;

    private int idComputadora;
    private String marca;
    private double precio;
    private Monitor monitor;
    private Teclado teclado;
    private Raton raton;

    private Computadora() {
        this.idComputadora = ++contComputadora;
    }

    public Computadora(String marca, double precio, Monitor monitor,
            Teclado teclado, Raton raton) {
        this();
        this.marca = marca;
        this.precio = precio;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    //get-set
    public static int getContComputadora() {
        return contComputadora;
    }

    public static void setContComputadora(int contComputadora) {
        Computadora.contComputadora = contComputadora;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Raton getRaton() {
        return raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    //toString
    @Override
    public String toString() {
        return "Computadora{" + "idComputadora=" + idComputadora + ", marca="
                + marca + ", precio=" + precio + ", monitor=" + monitor
                + ", teclado=" + teclado + ", raton=" + raton + '}';
    }

}
