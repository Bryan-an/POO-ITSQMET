//Paso por referencia
package com.desarrollo.pasoreferencia;

/**
 *
 * @author bryan
 */
public class ClaseEjecutablePersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear objeto
        Persona persona = new Persona("Bryan", 7);
        System.out.println("Nombre: " + persona.getNombre()); //nombre: Bryan
        cambiarValor(persona);
        System.out.println("Nuevo nombre: " + persona.getNombre()); //nombre: Andrés
    }
    
    public static void cambiarValor(Persona p) {
        p.setNombre("Andrés");
        p.setEdad(23);
    }
    
}
