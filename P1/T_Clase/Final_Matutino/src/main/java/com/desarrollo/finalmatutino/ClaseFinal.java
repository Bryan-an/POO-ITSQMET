/*
 * final
 */
package com.desarrollo.finalmatutino;

/**
 *
 * @author bryan
 */
public final class ClaseFinal {

    //constante
    private final int varNumero = 10;

    //constante-static
    private static final int VAR_NUMERO = 15;

    //objeto
    private static final Persona VAR_PERSONA = new Persona("Bryan");

    public int getVarNumero() {
        return varNumero;
    }

    public static int getVAR_NUMERO() {
        return VAR_NUMERO;
    }

    public static Persona getVAR_PERSONA() {
        return VAR_PERSONA;
    }

}
