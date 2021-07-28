/*
 * Clases abstractas
 */
package com.desarrollo.figurasgeometrica;

import static java.lang.Math.*;

/**
 *
 * @author Bryan Andagoya
 */
public class Circulo extends FiguraGeometrica {

    public Circulo(String nombreFigura, double valor1) {
        super(nombreFigura, valor1);
    }

    @Override
    public void dibujar() {
        System.out.println("Se dibuja un: " + nombreFigura);
    }

    @Override
    public void area() {
        double area = PI * pow(valor1, 2);
        System.out.println("El área del circulo es: " + area);
    }

    @Override
    public String toString() {
        return "Circulo: " + super.toString();
    }

}
