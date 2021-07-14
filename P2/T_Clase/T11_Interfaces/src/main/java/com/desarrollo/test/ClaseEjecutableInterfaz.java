/*
 * Interfaces
 */
package com.desarrollo.test;

import com.desarrollo.datos.*;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccesoDatos acc;
        acc = new ImplementacionOracle();
        acc.insertar();
        acc.listar();

        acc = new ImplementacionMySQL();
        acc.insertar();
        acc.listar();

        System.out.println(AccesoDatos.MAX_REGISTROS);
    }

}
