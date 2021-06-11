/*
 * Azucarada
 */
package com.desarrollo.examen;

/**
 *
 * @author bryan
 */
public class Azucarada extends Bebida {

    //Fields 
    private String tipo;
    private double porcentajeAzucar;
    private boolean promocion;
    private static double precioTotal = 0;
    private static int contadorPromociones = 0;

    //Constructor
    /**
     * Constructor de la clase Azucarada.
     *
     * @param tipoBotella Tipo de botella.
     * @param litros Cantidad de litros.
     * @param precio Precio de la bebida.
     * @param tipo Tipo de bebida azucarada.
     * @param porcentajeAzucar Porcentaje de azucar de la bebida.
     * @param promocion ¿La bebida tiene promoción?
     */
    public Azucarada(String tipoBotella, double litros, double precio,
            String tipo, double porcentajeAzucar, boolean promocion) {
        super(tipoBotella, litros, precio);
        this.tipo = tipo;
        this.porcentajeAzucar = porcentajeAzucar;
        this.promocion = promocion;
        if (promocion == true) {
            super.setPrecio(super.getPrecio() * 0.85);
            calcularBebidasDescuento();
        }
        calcularTotal();
    }

    //Getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPorcentajeAzucar() {
        return porcentajeAzucar;
    }

    public void setPorcentajeAzucar(double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }

    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    public static double getPrecioTotal() {
        return precioTotal;
    }

    public static void setPrecioTotal(double precioTotal) {
        Azucarada.precioTotal = precioTotal;
    }

    public static int getContadorPromociones() {
        return contadorPromociones;
    }

    public static void setContadorPromociones(int contadorPromociones) {
        Azucarada.contadorPromociones = contadorPromociones;
    }

    //Métodos
    /**
     * Método que calcula el total a pagar por las pacas de bebidad azucaradas.
     */
    public void calcularTotal() {
        Azucarada.precioTotal += super.getPrecio();
    }

    /**
     * Método que cuenta cuántas bebidas tienen descuento.
     */
    public void calcularBebidasDescuento() {
        Azucarada.contadorPromociones++;
    }

    @Override
    public String toString() {
        return "Azucarada{" + super.toString() + "; tipo = " + tipo
                + "; porcentaje de azucar = " + porcentajeAzucar + " %; promocion = "
                + promocion + '}';
    }

}
