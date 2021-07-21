/*
 * Colecciones
 */
package com.desarrollo.colecciones;

import java.util.*;

/**
 * Creada en 21/7/2021
 *
 * @author Bryan Andagoya
 */
public class ManejoColecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ArrayList -> implementa la interfaz List
        //ArrayList lista = new ArrayList();
        List lista = new ArrayList();

        //añadir elementos
        lista.add(3);
        lista.add(2);
        lista.add(2);
        lista.add(1);
        lista.add(0);
        lista.add("Viviana");
        lista.add(6.4);

        System.out.println("Elementos en la lista");
        lista.forEach(System.out::println);

        //Set -> no permite el almacenamiento de valores duplicados
        //HashSet conjunto = new HashSet();
        Set conjunto = new HashSet();
        conjunto.add(400);
        conjunto.add(200);
        conjunto.add("100");
        conjunto.add(400); //este valor no se almacena porque ya existe

        System.out.println("\nElementos en el conjunto");
        conjunto.forEach(System.out::println);

        //Map -> clave, valor
        Map mapaDatos = new HashMap();
        mapaDatos.put(1, "Steven");
        mapaDatos.put(2, "Monica");
        mapaDatos.put(3, "Valeria");
        mapaDatos.put(4, "Johan");

        System.out.println("\nElementos en el mapa");
        mapaDatos.forEach((t, u) -> System.out.println("clave: " + t + "; valor: " + u));
        //mapaDatos.entrySet().forEach(System.out::println);
    }
}
