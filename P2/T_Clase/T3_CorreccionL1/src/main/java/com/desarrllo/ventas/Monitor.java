/*
 * Corrección del L1: Diseño de clases
 */
package com.desarrllo.ventas;

/**
 *
 * @author bryan
 */
public class Monitor {

    private int idMonitor;
    private String marca;
    private double tamanio;
    private static int contMonitor = 0;

    private Monitor() {
        this.idMonitor = ++contMonitor;
    }

    public Monitor(String marca, double tamanio) {
        this();
        this.marca = marca;
        this.tamanio = tamanio;
    }

    //get-set
    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public static int getContMonitor() {
        return contMonitor;
    }

    public static void setContMonitor(int contMonitor) {
        Monitor.contMonitor = contMonitor;
    }

    //toString
    @Override
    public String toString() {
        return "Monitor{" + "idMonitor=" + idMonitor + ", marca=" + marca
                + ", tamanio=" + tamanio + '}';
    }

}
