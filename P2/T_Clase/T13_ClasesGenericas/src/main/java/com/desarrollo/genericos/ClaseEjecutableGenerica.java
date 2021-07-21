/*
 * Clases genéricas
 */
package com.desarrollo.genericos;

import java.util.*;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableGenerica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var generica = new ClaseGenerica<String>("Viviana");
        generica.obtenerTipoClase();

        var lista = new ArrayList<Double>();
        lista.add(3.4);
        //lista.add("Viviana"); //Solo se limita a datos de tipo Double
    }

}
