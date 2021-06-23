/*
 * Corrección del L1: Diseño de clases
 */
package com.desarrllo.ventas;

/**
 *
 * @author bryan
 */
public class DispositivosEntrada {

    private String tipoEntrada;
    private String marca;

    public DispositivosEntrada() {

    }

    public DispositivosEntrada(String tipoEntrada, String marca) {
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    //Get-set
    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //toString
    @Override
    public String toString() {
        return ", tipoEntrada=" + tipoEntrada + ", marca=" + marca;
    }

}
