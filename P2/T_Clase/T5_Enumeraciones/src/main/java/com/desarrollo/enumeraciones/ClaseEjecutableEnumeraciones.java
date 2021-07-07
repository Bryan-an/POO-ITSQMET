/*
 * Enumeraciones
 */
package com.desarrollo.enumeraciones;

import java.util.Arrays;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableEnumeraciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String continente = "EUROPA";

        System.out.println("Día 1: " + DiasSemana.LUNES);

        //Enumeraciones continentes
        System.out.println("Continente N°1: " + Continentes.EUROPA);
        System.out.println("Número de países: " + Continentes.EUROPA.getPaises());

        //imprimir todas las constantes
        imprimir();
        imprimirParametro(Continentes.valueOf(continente));
    }

    public static void imprimir() {
//        for (Continentes continente : Continentes.values()) {
//            System.out.println("Continente: " + continente + "paises: "
//                    + continente.getPaises());
//        }

        Arrays.asList(Continentes.values())
                .forEach(c -> System.out.println("Continente: " + c
                + "; paises: " + c.getPaises()));
    }

    public static void imprimirParametro(Continentes continente) {
        System.out.println("");
        switch (continente) {
            case AFRICA:
                System.out.println("Continente: " + continente + " países: "
                        + continente.getPaises());
                break;
            case EUROPA:
                System.out.println("Continente: " + continente + " países: "
                        + continente.getPaises());
                break;
            default:
                throw new AssertionError();
        }

    }
}
