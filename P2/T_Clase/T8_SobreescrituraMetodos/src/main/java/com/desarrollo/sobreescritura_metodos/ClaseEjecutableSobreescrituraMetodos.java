/*
 * Sobreescritura de métodos
 */
package com.desarrollo.sobreescritura_metodos;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableSobreescrituraMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var empleado = new Empleado("Santiago", 1200);
        System.out.println(empleado.obtenerInformacion());

        var gerente = new Gerente("Vale", 1000, "Sistemas");
        System.out.println(gerente.obtenerInformacion());
    }

}
