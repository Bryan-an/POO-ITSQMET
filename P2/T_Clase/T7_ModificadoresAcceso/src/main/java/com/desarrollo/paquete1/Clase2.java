/*
 * Modificadores de acceso
 */
package com.desarrollo.paquete1;

/**
 *
 * @author Bryan Andagoya
 */
public class Clase2 {

    Clase1 clase1;

    public Clase2() {
        clase1 = new Clase1("Vivi"); //constructor público
        clase1 = new Clase1(29); //constructor protegido
        clase1 = new Clase1(1.60); //constructor default
    }

    public void pruebaAtributos() {
        System.out.println(clase1.atributoPublico);
        System.out.println(clase1.atributoProtegido);
        System.out.println(clase1.atributoDefault);
    }

    public void pruebaMetodo() {
        clase1.metodoPublico();
        clase1.metodoProtegido();
        clase1.metodoDefault();
    }
    
    public static void main(String[] args) {
        Clase2 clase2 = new Clase2();
        clase2.pruebaAtributos();
        clase2.pruebaMetodo();
    }
}
