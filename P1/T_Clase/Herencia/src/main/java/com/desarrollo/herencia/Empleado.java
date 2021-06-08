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
    private static int contEmpleado = 0;
    private int idEmpleado;
    private int horasT;
    private double valorH;

    //constructor en vacío
    public Empleado() {
        this.idEmpleado = ++contEmpleado;
    }

    public Empleado(int horasT, double valorH) {
        this();     //se llama al constructor vació de la clase padre 
        //porque el constructor Empleado sin argumentos 
        //no tiene la declaración super

        //this("dfs",'c', 78,"df", 78, 41);     //se llama al constructor con argumentos 
        //de la clase padre porque el constructor 
        //Empleado con argumentos declara super con argumentos
        this.horasT = horasT;
        this.valorH = valorH;
    }

    //Constructor
    public Empleado(String nombre, char genero, int edad, String direccion, int horasT, double valorH) {
        //Se debe llamar al constructor de la clase padre
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
        return super.toString() + "Empleado{" + "idEmpleado=" + idEmpleado
                + ", horasT=" + horasT + ", valorH=" + valorH + '}';
    }

    //Métodos
    public void calcularSueldo() {
        double sueldo;

        sueldo = horasT * valorH;
        System.out.println("El sueldo del empleado es: " + sueldo);
    }

}
