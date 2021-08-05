/*
 * Manejo de archivos
 */
package com.desarrollo.test;

import com.desarrollo.negocio.*;
import java.util.*;

/**
 *
 * @author Bryan Andagoya
 */
public class CPJLaboratorioFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        String nombreArchivo = "src/main/java/com/desarrollo/archivo/peliculas.txt";
        String nombrePelicula;
        String genero;
        double precio;

        Scanner sc = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        do {
            System.out.println("\nMenú películas desarrollo");
            System.out.println("1. Inciciar archivo");
            System.out.println("2. Agregar película");
            System.out.println("3. Listar películas");
            System.out.println("4. Buscar película");
            System.out.println("5. Eliminar archivo");
            System.out.println("6. Salir");
            System.out.println("\nEscoja una opción: ");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    catalogo.inciciarArchivo(nombreArchivo);
                    break;

                case 2:
                    System.out.println("\nInformación película");
                    System.out.println("Nombre: ");
                    nombrePelicula = sc.next();

                    System.out.println("Género: ");
                    genero = sc.next();

                    System.out.println("Precio: ");
                    precio = sc.nextDouble();

                    catalogo.agregarPelicula(nombrePelicula, genero, precio,
                            nombreArchivo);

                    break;

                case 3:
                    catalogo.listarPeliculas(nombreArchivo);
                    
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la película a buscar: ");
                    nombrePelicula= sc.next();
                    
                    catalogo.buscarPelicula(nombreArchivo, nombrePelicula);
                    
                    break;
                case 5:

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
