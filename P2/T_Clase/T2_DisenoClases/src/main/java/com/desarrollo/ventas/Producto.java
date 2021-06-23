/*
 * Diseño de clases
 */
package com.desarrollo.ventas;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class Producto {

    //Campos
    private static int contProducto;

    private int idProducto;
    private String nombre;
    private double precio;

    //Constructores
    private Producto() {
        this.idProducto = ++contProducto;
    }

    public Producto(String nombre, double precio) {
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    //get-set
    public static int getContProducto() {
        return contProducto;
    }

    public static void setContProducto(int contProducto) {
        Producto.contProducto = contProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

}
