/*
Herencia en Java
 */
package com.desarrollo.herencia;

/**
 *
 * @author bryan
 */
public class Cliente extends Persona {

    //Atributos
    private int idCliente;
    private String vip;
    private static int contCliente = 0;

    //Constructor
    public Cliente(String nombre, char genero, int edad, String direccion, String vip) {
        super(nombre, genero, edad, direccion);
        this.idCliente = ++contCliente;
        this.vip = vip;
    }

    //Get-Set
    public int getIdCliente() {
        return idCliente;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public static int getContCliente() {
        return contCliente;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "idCliente=" + idCliente + ", vip=" + vip + '}';
    }

}
