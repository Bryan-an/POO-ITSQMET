/*
 * Clases abstractas
 */
package com.desarrollo.figurasgeometrica;

/**
 *
 * @author Bryan Andagoya
 */
public abstract class FiguraGeometrica {

    //definir atributos
    protected String nombreFigura;
    protected double valor1;

    //Constructor
    public FiguraGeometrica(String nombreFigura, double valor1) {
        this.nombreFigura = nombreFigura;
        this.valor1 = valor1;
    }

    //Definir métodos abstractos
    //No tienen cuerpo
    public abstract void dibujar();

    public abstract void area();

    //get-set
    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    //toString()
    @Override
    public String toString() {
        return "nombreFigura=" + nombreFigura + ", valor1=" + valor1;
    }

}
