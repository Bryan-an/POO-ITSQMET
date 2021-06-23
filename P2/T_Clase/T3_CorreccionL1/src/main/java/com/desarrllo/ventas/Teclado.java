/*
 * Corrección del L1: Diseño de clases
 */
package com.desarrllo.ventas;

/**
 *
 * @author bryan
 */
public class Teclado extends DispositivosEntrada {

    private int idTeclado;
    private static int contTeclado = 0;

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idTeclado = ++contTeclado;
    }

    //get-set
    public int getIdTeclado() {
        return idTeclado;
    }

    public void setIdTeclado(int idTeclado) {
        this.idTeclado = idTeclado;
    }

    public static int getContTeclado() {
        return contTeclado;
    }

    public static void setContTeclado(int contTeclado) {
        Teclado.contTeclado = contTeclado;
    }

    //toString
    @Override
    public String toString() {
        return "Teclado{" + "idTeclado=" + idTeclado + super.toString() + '}';
    }

}
