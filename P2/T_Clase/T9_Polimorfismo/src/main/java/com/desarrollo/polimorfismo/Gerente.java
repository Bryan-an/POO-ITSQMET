/*
 * Polimorfismo
 */
package com.desarrollo.polimorfismo;

/**
 *
 * @author Bryan Andagoya
 */
public class Gerente extends Empleado {

    private String departamento;

    public Gerente(String nombre, double sueldo, String departamento) {
        super(nombre, sueldo);
        this.departamento = departamento;
    }

    //Sobreescribir un método
    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion()
                + "\nDepartamento: " + departamento;
    }

    //get-set
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
