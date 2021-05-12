/*
Encapsulamiento
 */
package com.desarrollo.encapsulamiento;

/**
 *
 * @author bryan
 */
public class ClaseEjecutablePersona {

    //Variables de clase
    String nombre;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear objeto
        Persona persona = new Persona("Bryan", 20, 380);

//        persona.setNombre("Andrés");
//        persona.setEdad(32);
//        persona.setSueldo(1000);
        System.out.println(persona);
    }

    public void prueba() {
        System.out.print("Nombre: " + nombre);
    }
}
