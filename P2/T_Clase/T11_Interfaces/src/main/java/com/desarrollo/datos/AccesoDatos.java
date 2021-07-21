/*
 * Interfaces
 */
package com.desarrollo.datos;

/**
 * Una interfaz sólo puede heredar de otra interfaz
 * 
 * @author Bryan Andagoya
 */
public interface AccesoDatos {

    //atributos en una interface son constantes
    //public static final <type> <identifier>;
    int MAX_REGISTROS = 10;

    //no se define constructores
    //métodos abstractos
    //solo se puede utilizar el modificador de acceso public
    public abstract void insertar();

    //no es necesario colocar public abstract
    void listar();
}
