/*
 * Manejo de archivos
 */
package com.desarrollo.manejoarchivos;

import java.io.*;
import java.nio.charset.Charset;

/**
 *
 * @author Bryan Andagoya
 */
public class Archivo {
    //método crear archivo

    public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try {
            if (archivo.exists()) {
                System.out.println("\nEl archivo ya existe");
            } else {
                archivo.createNewFile();
                System.out.println("\nEl archivo se ha creado correctamente");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
//        try (PrintWriter crearArchivo = new PrintWriter(archivo)) {
//            //cerrar flujo para la creación del archivo
//            System.out.println("El archivo se ha creado correctamente");
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace(System.out);
//        }

    }

    //método escritura archivo
    public static void escribirArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try (PrintWriter escritor = new PrintWriter(archivo, "UTF-8")) {
            String contenido = "Texto nuevo a agregar en el archivo";
            escritor.println(contenido);
            escritor.println();
            escritor.println("Terminó la escritura");

            System.out.println("\nSe ha escrito en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //método lectura archivo
    public static void leerArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        String texto;

        try (BufferedReader lector
                = new BufferedReader(new FileReader(archivo, Charset.forName("UTF-8")))) {

            texto = lector.readLine();

            while (texto != null) {
                System.out.println(texto);
                texto = lector.readLine();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void agregarTextoArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try (PrintWriter escritor
                = new PrintWriter(new FileWriter(archivo,
                        Charset.forName("UTF-8"), true))) { //añadir texto a un archivo existente

            String contenido = "Agregar texto adicional";
            escritor.println(contenido);
            escritor.println();
            escritor.println("Fin - no hay más texto");
            System.out.println("\nSe ha agregado el nuevo texto");

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        if (archivo.delete()) {
            System.out.println("\nEl archivo ha sido eliminado");
        } else {
            System.out.println("\nEl archivo no se ha encontrado");
        }
    }
}
