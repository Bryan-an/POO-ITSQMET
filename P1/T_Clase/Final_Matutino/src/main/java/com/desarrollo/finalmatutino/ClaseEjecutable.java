/*
 * final
 */
package com.desarrollo.finalmatutino;

/**
 *
 * @author bryan
 */
public class ClaseEjecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClaseFinal c = new ClaseFinal();
        //c.varNumero = 45;
        System.out.println("Constante: " + c.getVarNumero() + Math.PI);

        System.out.println("Constante estática: " + ClaseFinal.getVAR_NUMERO());
        //ClaseFinal.VAR_PERSONA = new Persona("Johan");
    }

}
