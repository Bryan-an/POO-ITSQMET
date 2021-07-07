/*
 * Enumeraciones
 */
package com.desarrollo.enumeraciones;

/**
 * Continentes
 *
 * @author Bryan Andagoya
 */
public enum Continentes {
    AFRICA(53),
    EUROPA(46),
    ASIA(44),
    AMERICA(34),
    OCEANIA(14);

    //constante
    private final int paises;

    //Constructor
    Continentes(int paises) {
        this.paises = paises;
    }

    //get
    public int getPaises() {
        return paises;
    }

}
