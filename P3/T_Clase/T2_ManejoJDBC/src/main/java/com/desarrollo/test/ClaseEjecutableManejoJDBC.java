/*
 * Clase ejecutable
 */
package com.desarrollo.test;

import com.desarrollo.datos.PersonaDAO;
import com.desarrollo.domain.Persona;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bryan Andagoya
 */
public class ClaseEjecutableManejoJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);
        List<Persona> personas;
        String nombre, apellido, email;
        int edad, telefono;

        //objeto persona DAO
        PersonaDAO personaDAO = new PersonaDAO();

        do {
            System.out.println("Menú operaciones");
            System.out.println("1. Listar personas");
            System.out.println("2. Insertar persona");
            System.out.println("3. Salir");
            System.out.println("Escoja una opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    personas = personaDAO.select();

                    for (Persona persona : personas) {
                        System.out.println(persona);
                    }
                    break;
                case 2:
                    System.out.println("Información persona");
                    System.out.println("Nombre");
                    nombre = sc.next();
                    System.out.println("Apellido");
                    apellido = sc.next();
                    System.out.println("Edad");
                    edad = sc.nextInt();
                    System.out.println("Teléfono:");
                    telefono = sc.nextInt();
                    System.out.println("Email:");
                    email = sc.next();
                    //generar objeto
                    Persona persona = new Persona(nombre, apellido, edad, telefono, email);

                    System.out.println("Los registros insertados son: "
                            + personaDAO.insert(persona));
                    break;
                case 3:
                    System.out.println("Gracias por utilizar nuestro programa");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (op != 3);
    }

}
