/*
 * Interfaces
 */
package com.desarrollo.datos;

/**
 * Herencia -> extends -> solo se puede heredar de una clase o una interfaz
 * Implementación -> implements -> se puede implementar de n interfaces
 *
 * @author Bryan Andagoya
 */
public class ImplementacionOracle implements AccesoDatos {

    @Override
    public void insertar() {
        System.out.println("Insetar desde Oracle");
    }

    @Override
    public void listar() {
        System.out.println("Listar desde Oracle");
    }

}
