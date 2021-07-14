/*
 * Interfaces
 */
package com.desarrollo.datos;

/**
 *
 * @author Bryan Andagoya
 */
public class ImplementacionMySQL implements AccesoDatos {

    @Override
    public void insertar() {
        System.out.println("Insertar desde MySQL");
    }

    @Override
    public void listar() {
        System.out.println("Listar desde MySQL");
    }

}
