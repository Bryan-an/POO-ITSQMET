/*
Operaciones aritméticas
 */
package com.desarrollo.operaciones;

/**
 * 
 * @author bryan
 */
public class Aritmetica {

    //atributos
    double resultado;

    //métodos
    //método void
    public void sumaVoid(double num1, double num2) {  //parámetros --> esperan un valor y se pasan de una clase a otra
        resultado = num1 + num2;
        System.out.println("La suma es: " + resultado);
    }

    //método return --> retornan un valor
    //el tipo del método depende del valor que va a retornar
    public double sumaReturn(double num1, double num2) {
        resultado = num1 + num2;
        return resultado;
    }
    
    //Deber: Hacer los métodosresta, multiplicación, división
    //restricciones división:
    //0/0 --> indeterminación
    //4/0 --> no existe división para cero
    
    public void resta(double num1, double num2){
        System.out.println("La resta es: " + (num1 - num2));
    }
}
