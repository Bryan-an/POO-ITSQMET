/*
 * Polimorfismo
 */
package com.desarrollo.polimorfismo;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableSobreescrituraMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado empleado; //crear objeto desde la clase padre
        empleado = new Empleado("Santiago", 1200);
        System.out.println(empleado.obtenerInformacion());

        empleado = new Gerente("Vale", 1000, "Sistemas");
        System.out.println(empleado.obtenerInformacion());
    }

}
