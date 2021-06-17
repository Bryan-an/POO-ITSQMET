/*
 * Diseño de clases
 */
package com.desarrollo.test;

import com.desarrollo.ventas.Orden;
import com.desarrollo.ventas.Producto;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Ventas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Orden orden = new Orden();
        String nombre;
        double precio;
        char resp;

        System.out.println("Tecnomega");
        do {
            System.out.println("Información del producto");
            System.out.println("Nombre:");
            nombre = sc.next();
            System.out.println("Precio:");
            precio = sc.nextDouble();

            //metodo vector
            Producto producto = new Producto(nombre, precio);
            if (orden.agregarProducto(producto)) {
                System.out.println("El producto se ha agregó correctamente");
            } else {
                System.out.println("Se ha superado la cantidad de productos");
            }

            //metodo colección
            orden.agregarProductoColeccion(producto);

            System.out.println("Desea ingresar otro producto (s/n):");
            resp = sc.next().charAt(0);
        } while (resp == 's');

        //metodo vector
        orden.detalleOrden();
        System.out.println("");

        //metodo coleccion
        orden.detalleOrdenColeccion();
    }

}
