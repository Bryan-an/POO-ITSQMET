/*
 * Diseño de clases
 */
package com.desarrollo.ventas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class Orden {

    //Campos
    private static int contOrden = 0;
    private static final int CANT_PRODUCTOS = 10; //Constante 
    private static int indice = 0;

    private int idOrden;
    private Producto productos[];
    private ArrayList<Producto> productosColeccion; //Coleccion

    //Constructor
    public Orden() {
        this.idOrden = ++contOrden;
        productos = new Producto[CANT_PRODUCTOS];
        productosColeccion = new ArrayList();
    }

    //Métodos
    public boolean agregarProducto(Producto producto) {
        boolean bandera;

        if (indice < CANT_PRODUCTOS) {
            productos[indice++] = producto;
            bandera = true;
        } else {
            bandera = false;
        }

        return bandera;
    }

    public void agregarProductoColeccion(Producto producto) {
        productosColeccion.add(producto);
        System.out.println("El producto se ha agregado correctamente");
    }

    public double calcularTotal() {
//        double total = 0;
//
//        for (int i = 0; i < indice; i++) {
//            total += productos[i].getPrecio();
//        }
//
//        return total;

        return Arrays.asList(productos).stream().filter(p
                -> p != null).mapToDouble(p -> p.getPrecio()).sum();
    }

    public double calcularTotalColeccion() {
//        double total = 0;
//        
//        for (Producto producto : productos) {
//            total += producto.getPrecio();
//        }
//        
//        return total;

        return productosColeccion.stream().mapToDouble(p
                -> p.getPrecio()).sum();
    }

    public void detalleOrden() {
        System.out.println("Orden N°: " + idOrden);
        System.out.println("Productos");

//        for (int i = 0; i < indice; i++) {
//            System.out.println(productos[i]);
//        }
        Arrays.asList(productos).stream().filter(p
                -> p != null).forEach(System.out::println);

        System.out.println("\nTotal a pagar: " + calcularTotal());

    }

    public void detalleOrdenColeccion() {
        System.out.println("Orden N°: " + idOrden);
        System.out.println("Productos");
        productosColeccion.forEach(System.out::println);
        System.out.println("\nTotal a pagar: " + calcularTotalColeccion());
    }

}
