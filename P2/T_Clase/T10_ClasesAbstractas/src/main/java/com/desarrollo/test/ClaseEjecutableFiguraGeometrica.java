/*
 * Clases abstractas
 */
package com.desarrollo.test;

import com.desarrollo.figurasgeometrica.*;
import java.util.List;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableFiguraGeometrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear objeto
        FiguraGeometrica fg;
        //referencia de la clase abstracta no es posible
        //fg = new FiguraGeometrica("Figura", 3.4);
        //se puede pasar la referencia de las clases hijas
        fg = new Circulo("Círculo", 3.4);
        fg.dibujar();
        fg.area();
        System.out.println(fg);

        fg = new Rectangulo("Rectángulo", 4, 9);
        fg.dibujar();
        fg.area();
        System.out.println(fg);

        fg = new Triangulo("Triángulo", 3.5, 2);
        fg.dibujar();
        fg.area();
        System.out.println(fg);

        fg = new Cuadrado("Cuadrado", 7);
        fg.dibujar();
        fg.area();
        System.out.println(fg);
    }

}
