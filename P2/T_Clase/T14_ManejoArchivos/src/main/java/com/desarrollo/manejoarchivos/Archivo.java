/*
 * Manejo de archivos
 */
package com.desarrollo.manejoarchivos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Andagoya
 */
public class Archivo {
    //método crear archivo

    public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter crearArchivo = new PrintWriter(archivo);
            //cerrar flujo para la creación del archivo
            crearArchivo.close();
            System.out.println("El archivo se ha creado correctamente");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //método escritura archivo
    public static void escribirArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter escrituraArchivo = new PrintWriter(nombreArchivo);
            String contenido = "Texto nuevo a agregar en el archivo";
            escrituraArchivo.println(contenido);
            escrituraArchivo.println();
            escrituraArchivo.println("Terminó la escritura");

            escrituraArchivo.close();
            System.out.println("Se ha escrito en el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //método lectura archivo
    public static void leerArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        String texto;

        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));

            texto = lectura.readLine();

            while (texto != null) {
                System.out.println(texto);
                texto = lectura.readLine();
            }

            lectura.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void agregarTextoArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter agregarTexto = new PrintWriter(new FileWriter(archivo, true)); //añadir texto a un archivo existente
            String contenido = "Agregar texto adicional";
            agregarTexto.println(contenido);
            agregarTexto.println();
            agregarTexto.println("Fin - no hay más texto");
            System.out.println("Se ha agregado el nuevo texto");

            agregarTexto.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        if (archivo.delete()) {
            System.out.println("El archivo ha sido eliminado");
        } else {
            System.out.println("El archivo no se ha encontrado");
        }
    }
}
