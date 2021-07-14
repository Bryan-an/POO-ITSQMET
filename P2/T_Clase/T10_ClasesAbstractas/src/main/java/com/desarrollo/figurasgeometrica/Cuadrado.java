/*
 * Clases abstractas
 */
package com.desarrollo.figurasgeometrica;

/**
 *
 * @author Bryan Andagoya
 */
public class Cuadrado extends FiguraGeometrica {

    public Cuadrado(String nombreFigura, double valor1) {
        super(nombreFigura, valor1);
    }

    @Override
    public void dibujar() {
        System.out.println("Se dibuja un: " + nombreFigura);
    }

    @Override
    public void area() {
        double area = Math.pow(valor1, 2);
        System.out.println("El área del cuadrado es: " + area);
    }

    //toString
    @Override
    public String toString() {
        return "Cuadrado: " + super.toString();
    }

}
