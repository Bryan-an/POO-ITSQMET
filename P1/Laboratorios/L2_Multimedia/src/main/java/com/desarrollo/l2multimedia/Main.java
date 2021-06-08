/*
Laboratorio 2
 */
package com.desarrollo.l2multimedia;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public final class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    //Atributos
    private Scanner sc = new Scanner(System.in);
    private final int PELICULA = 1, DISCO = 2;

    //Construcor
    private Main() {
        desplegarMenu();
    }

    //Métodos
    public void desplegarMenu() {

        int numeroOpcion;

        do {
            System.out.println("\nLaboratorio 2"
                    + "\n1. Pelicula"
                    + "\n2. Disco"
                    + "\n3. Salir"
                    + "\nDigite una opción:");
            numeroOpcion = sc.nextInt();
            sc.nextLine();

            switch (numeroOpcion) {
                case 1:
                    pedirDatos(PELICULA);
                    break;
                case 2:
                    pedirDatos(DISCO);
                    break;
                case 3:
                    System.out.println("\nPrograma finalizado correctamente");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (numeroOpcion != 3);
    }

    public void pedirDatos(int TIPO_MULTIMEDIA) {
        String titulo;
        String autor;
        String formato;
        double precio;
        int duracion;

        System.out.println("\nIngrese el título:");
        titulo = sc.nextLine();

        System.out.println("\nIngrese el autor:");
        autor = sc.nextLine();

        System.out.println("\nIngrese el formato:");
        formato = sc.nextLine();

        System.out.println("\nIngrese el precio:");
        precio = sc.nextDouble();

        System.out.println("\nIngrese la duración(min):");
        duracion = sc.nextInt();
        sc.nextLine();

        switch (TIPO_MULTIMEDIA) {
            case PELICULA:
                crearPelicula(titulo, autor, formato, precio, duracion);
                break;
            case DISCO:
                crearDisco(titulo, autor, formato, precio, duracion);
                break;
        }
    }

    public void crearPelicula(String titulo, String autor, String formato, double precio, int duracion) {
        String actor;

        System.out.println("\nIngrese el actor o actriz principal de la película:");
        actor = sc.nextLine();

        Pelicula pelicula = new Pelicula(titulo, autor, formato, precio, duracion, actor);
        pelicula.descuento();
        System.out.println(pelicula);
    }

    public void crearDisco(String titulo, String autor, String formato, double precio, int duracion) {
        int capacidad;

        System.out.println("\nIngrese la capacidad del disco(MB):");
        capacidad = sc.nextInt();
        sc.nextLine();

        Disco disco = new Disco(titulo, autor, formato, precio, duracion, capacidad);
        System.out.println(disco);
    }
}
