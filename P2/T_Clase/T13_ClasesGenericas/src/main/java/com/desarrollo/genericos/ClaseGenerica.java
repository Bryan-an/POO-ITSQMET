/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.genericos;

/**
 *
 * @author Bryan Andagoya
 * @param <T> Data type.
 */
public class ClaseGenerica<T> {

    //Definir variable generica
    T objeto;

    //constructor
    public ClaseGenerica(T objeto) {
        this.objeto = objeto;
    }

    //métodos que permita obtener el tipo de la clase 
    public void obtenerTipoClase() {
        System.out.println("Tipo de la clase: " + objeto.getClass()
                .getSimpleName());

        //Uso del operador instanceof
        if (objeto instanceof String) {
            System.out.println(((String) objeto).concat(" esto si funciona"));
        } else if (objeto instanceof Integer) {
            System.out.println((int) objeto + 3);
        }
    }
}
