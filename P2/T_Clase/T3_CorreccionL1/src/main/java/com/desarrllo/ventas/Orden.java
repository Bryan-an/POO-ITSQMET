/*
 * Corrección del L1: Diseño de clases
 */
package com.desarrllo.ventas;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author bryan
 */
public class Orden {

    private int idOrden;
    private Computadora[] computadoras;
    private static int contOrden = 0;
    private static int index = 0;
    //constante
    private static final int CANT_COMPUTADORAS = 10;

    public Orden() {
        this.idOrden = ++contOrden;
        computadoras = new Computadora[CANT_COMPUTADORAS];
    }

    //Método agregar
    public void agregarComputadora(Computadora computadora) {
        if (index < CANT_COMPUTADORAS) {
            this.computadoras[index++] = computadora;
        } else {
            System.out.println("\nSe ha superado el máximo de computadoras a la orden");
        }
    }

    //método calculartotal
    public double calcularTotal() {
//        double totalPagar = 0;
//
//        for (int i = 0; i < index; i++) {
//            totalPagar = totalPagar + this.computadoras[i].getPrecio();
//        }
//
//        return totalPagar;
        return Arrays.asList(computadoras)
                .stream()
                .filter(computadora -> computadora != null)
                .mapToDouble(computadora -> computadora.getPrecio()).sum();
    }

    public double descuentoOrden() {
        double descuento;
        double totalPagar = calcularTotal();

        if (index > 2) {
            System.out.println("Ha recibido un descuento del 20%");
            descuento = totalPagar * 0.80;
        } else {
            System.out.println("No ha recibido descuento");
            descuento = totalPagar;
        }

        return descuento;
    }

    public void mostrarOrden() {
        System.out.println("\nOrden N°: " + this.idOrden);
        System.out.println("\nComputadoras");

//        for (int i = 0; i < index; i++) {
//            System.out.println(computadoras[i]);
//        }
        Arrays.asList(computadoras)
                .stream()
                .filter(computadora -> computadora != null)
                .forEach(System.out::println);

        System.out.println("\nTotal compra: " + calcularTotal());
        System.out.println("Total a pagar: " + descuentoOrden());
    }
}
