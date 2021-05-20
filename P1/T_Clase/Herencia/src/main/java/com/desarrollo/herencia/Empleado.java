/*
Herencia en Java
 */
package com.desarrollo.herencia;

/**
 *
 * @author bryan
 */
public class Empleado extends Persona {

    //Atributos
    private int idEmpleado;
    private int horasT;
    private double valorH;
    private static int contEmpleado = 0;

    //Constructor
    public Empleado(String nombre, char genero, int edad, String direccion, int horasT, double valorH) {
        //Se debe llamar a constructor de la clase padre
        super(nombre, genero, edad, direccion);
        this.idEmpleado = ++contEmpleado;
        this.horasT = horasT;
        this.valorH = valorH;
    }

    //Ger-Set
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getHorasT() {
        return horasT;
    }

    public void setHorasT(int horasT) {
        this.horasT = horasT;
    }

    public double getValorH() {
        return valorH;
    }

    public void setValorH(double valorH) {
        this.valorH = valorH;
    }

    public static int getContEmpleado() {
        return contEmpleado;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "idEmpleado=" + idEmpleado + ", horasT=" + horasT + ", valorH=" + valorH + '}';
    }

    //Métodos
    public void calcularSueldo() {
        double sueldo;
        sueldo = horasT * valorH;
        System.out.println("El sueldo del empleado es: " + sueldo);
    }

}
