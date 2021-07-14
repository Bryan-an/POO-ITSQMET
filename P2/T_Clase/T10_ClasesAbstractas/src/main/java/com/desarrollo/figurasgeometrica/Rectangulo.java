/*
 * Clases abstractas
 */
package com.desarrollo.figurasgeometrica;

/**
 *
 * @author Bryan Andagoya
 */
public class Rectangulo extends FiguraGeometrica {

    private double valor2;

    public Rectangulo(String nombreFigura, double valor1, double valor2) {
        super(nombreFigura, valor1);
        this.valor2 = valor2;
    }

    @Override
    public void dibujar() {
        System.out.println("Se dibuja un: " + nombreFigura);
    }

    @Override
    public void area() {
        double area = valor1 * valor2;
        System.out.println("El área del rectángulo es: " + area);
    }

    //get-set
    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    //toString
    @Override
    public String toString() {
        return "Rectangulo: " + super.toString() + ", valor2=" + valor2;
    }

}
