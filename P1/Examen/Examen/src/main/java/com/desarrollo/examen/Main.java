/*
 * Main
 */
package com.desarrollo.examen;

import java.util.ArrayList;
import java.util.Scanner;

enum TipoBebida {
    AZUCARADA, AGUA;
}

/**
 * Creada por Bryan en 9/6/2021
 *
 * @author bryan
 */
public final class Main {

    //Fields
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Bebida> azucaradas = new ArrayList<Bebida>();
    private ArrayList<Bebida> aguas = new ArrayList<Bebida>();

    //Constructor
    /**
     * Constructor de la clase Main.
     */
    public Main() {
        displayMenu();
    }

    /**
     * Main thread.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Método que despliega el menú.
     */
    public void displayMenu() {
        int numeroOpcion;

        do {
            System.out.println("\n---------------Examen---------------"
                    + "\n1. Bebidas azucaradas"
                    + "\n2. Agua"
                    + "\n3. Total a pagar"
                    + "\n4. Salir"
                    + "\n\nEscoja una opción:");
            numeroOpcion = sc.nextInt();
            sc.skip("\n");

            realizarOperaciones(numeroOpcion);
        } while (numeroOpcion != 4);
    }

    /**
     * Método que realiza las operaciones del menú.
     *
     * @param numeroOpcion Numero de opción digitado por el usuario.
     */
    public void realizarOperaciones(int numeroOpcion) {
        switch (numeroOpcion) {
            case 1:
                pedirDatos(TipoBebida.AZUCARADA);
                break;
            case 2:
                pedirDatos(TipoBebida.AGUA);
                break;
            case 3:
                if (Bebida.getContadorBebidas() == 0) {
                    System.out.println("\nAún no se ha ingresado ninguna bebida");
                } else {
                    desplegarTotal();
                }
                break;
            case 4:
                System.out.println("\nGracias por utilizar nuestro programa");
                break;
            default:
                System.out.println("\nOpción inválida, intente de nuevo");
        }
    }

    /**
     * Método que pide los datos al usuario.
     *
     * @param TIPO_BEBIDA Tipo de bebida.
     */
    public void pedirDatos(TipoBebida TIPO_BEBIDA) {
        System.out.println("\nIngrese el tipo de botella:");
        String tipoBotella = sc.next();
        System.out.println("\nIngrese la cantidad de litros:");
        double litros = sc.nextDouble();
        System.out.println("\nIngrese el precio:");
        double precio = sc.nextDouble();
        sc.skip("\n");

        switch (TIPO_BEBIDA) {
            case AZUCARADA:
                System.out.println("\nIngrese el tipo de bebida azucarada:");
                String tipo = sc.next();
                System.out.println("\nIngrese el porcentaje de azúcar:");
                double porcentajeAzucar = sc.nextDouble();
                System.out.println("\nIndique si la bebida tiene promoción (s/n):");
                char aux = sc.next().toLowerCase().charAt(0);
                boolean promocion = (aux == 's');

                desplegarAzucarada(tipoBotella, litros, precio, tipo,
                        porcentajeAzucar, promocion);
                break;
            case AGUA:
                System.out.println("\nIngrese la marca (tesalia, cielo, natura):");
                String marca = sc.next().toLowerCase();

                desplegarAgua(tipoBotella, litros, precio, marca);
                break;
        }
    }

    /**
     * Método que imprime la bebida azucarada.
     *
     * @param tipoBotella Tipo de botella.
     * @param litros Cantidad de litros.
     * @param precio Precio de la bebida.
     * @param tipo Tipo de bebida azucarada.
     * @param porcentajeAzucar Porcentaje de azucar de la bebida.
     * @param promocion ¿La bebida tiene promoción?
     */
    public void desplegarAzucarada(String tipoBotella, double litros,
            double precio, String tipo, double porcentajeAzucar, boolean promocion) {
        Azucarada azucarada = new Azucarada(tipoBotella, litros, precio,
                tipo, porcentajeAzucar, promocion);
        azucaradas.add(azucarada);

        System.out.println("\n" + azucarada);
    }

    /**
     * Método que imprime el agua.
     *
     * @param tipoBotella Tipo de botella.
     * @param litros Cantidad de litros.
     * @param precio Precio de la bebida.
     * @param marca Marca de la bebida.
     */
    public void desplegarAgua(String tipoBotella, double litros, double precio,
            String marca) {
        Agua agua = new Agua(tipoBotella, litros, precio, marca);
        aguas.add(agua);

        System.out.println("\n" + agua);
    }

    /**
     * Método que despliega el total a pagar.
     */
    public void desplegarTotal() {
        double totalAzucaradas = Math.round(Azucarada.getPrecioTotal() * 100.0)
                / 100.00;
        double totalAguas = Math.round(Agua.getPrecioTotal() * 100.0) / 100.0;

        System.out.println("\nCantidad de pacas de bebidas azucaradas con descuento: "
                + Azucarada.getContadorPromociones());
        System.out.println("Cantidad de pacas de Tesalia: "
                + Agua.getContadorTesalia());
        System.out.println("Cantidad de pacas de Cielo: "
                + Agua.getContadorCielo());
        System.out.println("Cantidad de pacas de Natura: "
                + Agua.getContadorNatura());
        System.out.println("Total a pagar por todas las bebidas azucaradas: $ "
                + totalAzucaradas);
        System.out.println("Total a pagar por todas las aguas: $ "
                + totalAguas);
        System.out.println("Total a pagar por todas las bebidas: "
                + (totalAzucaradas + totalAguas));
        System.out.println("\nAguas:");
        aguas.forEach(System.out::println);
        System.out.println("\nBebidas Azucaradas:");
        azucaradas.forEach(System.out::println);
    }
}
