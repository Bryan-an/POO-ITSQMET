/*
 * Manejo de archivos
 */
package com.desarrollo.test;

import com.desarrollo.manejoarchivos.Archivo;
import java.util.Scanner;

/**
 *
 * @author Bryan Andagoya
 */
public class GestionArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int op;
        String nombreArchivo
                = "C:\\Users\\bryan\\OneDrive\\Documentos\\ITSQMET\\S2\\POO\\P2\\T_Clase\\T14_ManejoArchivos\\estudiantes.txt";

        Scanner sc = new Scanner(System.in);

        System.out.println("\nMenú archivo");
        System.out.println("-----------------------------------------------\n");

        do {
            System.out.println("\n1. Crear Archivo");
            System.out.println("2. Escribir Archivo");
            System.out.println("3. Leer Archivo");
            System.out.println("4. Agregar nuevo texto archivo");
            System.out.println("5. Eliminar archivo");
            System.out.println("6. Salir");
            System.out.println("\nEscoja una opción:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    Archivo.crearArchivo(nombreArchivo);
                    break;
                case 2:
                    Archivo.escribirArchivo(nombreArchivo);
                    break;
                case 3:
                    Archivo.leerArchivo(nombreArchivo);
                    break;
                case 4:
                    Archivo.agregarTextoArchivo(nombreArchivo);
                    break;
                case 5:
                    Archivo.eliminarArchivo(nombreArchivo);
                    break;
                case 6:
                    System.out.println("\nGracias por utilizar nuestro programa");
                    break;
                default:
                    System.out.println("\nOpción inválida");
            }
        } while (op != 6);
    }

}
