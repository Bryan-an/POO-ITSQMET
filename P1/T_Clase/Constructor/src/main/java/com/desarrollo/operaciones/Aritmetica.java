/*
Constructor 5-5-2021
 */
package com.desarrollo.operaciones;

/**
 *
 * @author bryan
 */
public class Aritmetica {

    //atributos
    double num1, num2, resultado;

    //constructor - el oonstructor siempre tiene el nombre de la clase
//    public Aritmetica() {
//        System.out.println("Constructor vacío");
//    }
    public Aritmetica(double num1, double num2) {
        //El labor del constructor es inicializar los atributos que son parte del objeto.
        this.num1 = num1;
        this.num2 = num2;
    }

    //métodos
    //método void
    public void sumaVoid() {  //parámetros --> esperan un valor y se pasan de una clase a otra
        resultado = num1 + num2;
        System.out.println("La suma es: " + resultado);
    }

    //método return --> retornan un valor
    //el tipo del método depende del valor que va a retornar
    public double sumaReturn() {
        resultado = num1 + num2;
        return resultado;
    }

    //Deber: Hacer los métodosresta, multiplicación, división
    //restricciones división:
    //0/0 --> indeterminación
    //4/0 --> no existe división para cero
    public void resta() {
        System.out.println("La resta es: " + (num1 - num2));
    }

    //multiplicación
    public void multiplicacion() {
        resultado = num1 * num2;
        System.out.println("La multiplicación es: " + resultado);
    }

    //división
    public void division() {
        if (num1 == 0 && num2 == 0) {
            System.out.println("INDETERMINACIÓN");
        } else if (num2 == 0) {
            System.out.println("NO EXISTE DIVISIÓN PARA CERO");
        } else {
            resultado = num1 / num2;
            System.out.println("La división es: " + resultado);
        }
    }
}
