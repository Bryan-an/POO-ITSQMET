/*
 * Modificadores de acceso
 */
package com.desarrollo.paquete2;

import com.desarrollo.paquete1.Clase1;

/**
 *
 * @author Bryan Andagoya
 */
public class Clase4 {

    Clase1 clase1;

    public Clase4() {
        clase1 = new Clase1("Vivi");
    }

    public void pruebaAtributos() {
        System.out.println(clase1.atributoPublico);
    }

    public void pruebaMetodos() {
        clase1.metodoPublico();
    }

    public static void main(String[] args) {
        Clase4 clase4 = new Clase4();
        clase4.pruebaAtributos();
        clase4.pruebaMetodos();
    }
}
