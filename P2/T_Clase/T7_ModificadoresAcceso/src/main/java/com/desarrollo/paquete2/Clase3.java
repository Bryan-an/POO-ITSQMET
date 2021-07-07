/*
 * Modificadores de acceso
 */
package com.desarrollo.paquete2;

import com.desarrollo.paquete1.Clase1;

/**
 *
 * @author Bryan Andagoya
 */
public class Clase3 extends Clase1 {

    public Clase3() {
        //super("Vivi"); //constructor público
        super(29); //constructor protected
    }
    
    public void pruebaAtributos(){
        Clase1 clase1 = new Clase1("Vivi");
        System.out.println(clase1.atributoPublico);
        System.out.println(atributoProtegido);
    }
    
    public void pruebaMetodos(){
        Clase1 clase1 = new Clase1("Vivi");
        clase1.metodoPublico();
        metodoProtegido();
    }
    
    public static void main(String[] args){
        Clase3 clase3 = new Clase3();
        clase3.pruebaAtributos();
        clase3.pruebaMetodos();
    }
}
