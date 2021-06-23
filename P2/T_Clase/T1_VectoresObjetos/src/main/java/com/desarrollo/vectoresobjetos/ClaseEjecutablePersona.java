/*
 * Vectores de Objetos
 */
package com.desarrollo.vectoresobjetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class ClaseEjecutablePersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Variables y objetos
        Scanner sc = new Scanner(System.in);
        String nombre;
        int cedula;
        String resp;

        //Definir vector
        Persona[] personas = new Persona[3];
        var personasCol = new ArrayList<Persona>();

        //Almacenar información
        for (int i = 0; i < personas.length; i++) {
            System.out.println("\nInformación persona:");
            System.out.println("Ingrese el nombre de la persona " + (i + 1)
                    + ":");
            nombre = sc.next();
            System.out.println("Ingrese la cédula de la persona " + (i + 1)
                    + ":");
            cedula = sc.nextInt();

            personas[i] = new Persona(nombre, cedula);
        }

        System.out.println("\nDetalle Personas:");
        Arrays.asList(personas).forEach(System.out::println);

//        for (Persona persona : personas) {
//            System.out.println(persona);
//        }
        do {
            System.out.println("\nInformación persona");
            System.out.println("Nombre:");
            nombre = sc.next();
            System.out.println("Cédula:");
            cedula = sc.nextInt();

            personasCol.add(new Persona(nombre, cedula));

            System.out.println("\nDesea ingresar otra persona si/no:");
            resp = sc.next();
        } while (resp.equals("si"));

        System.out.println("\nDetalles personas:");
        personasCol.forEach(System.out::println);
    }

}
