/*
 * Manejo de archivos
 */
package com.desarrollo.datos;

import com.desarrollo.domain.Pelicula;
import java.io.*;
import java.util.*;

/**
 *
 * @author Bryan Andagoya
 */
public class AccesoDatosImpl implements AccesoDatos {

    //Verificar si existe el archivo
    @Override
    public boolean existe(String nombreArchivo) {
        boolean archivoExiste;
        File archivo = new File(nombreArchivo);
        archivoExiste = archivo.exists(); //true, false
        return archivoExiste;
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            while (lectura != null) {
//                int indiceInicial;
//                int indiceFinal;

                char[] arrayLectura = lectura.toCharArray();
                boolean capturar = false;
                int indice = 0;
                String[] datosPelicula = {"", "", ""};
                String nombre;
                String genero;
                double precio;

//                datosPelicula = lectura.split(",");
//
//                indiceInicial = datosPelicula[0].indexOf("=") + 1;
//                nombre = datosPelicula[0].substring(indiceInicial);
//
//                indiceInicial = datosPelicula[1].indexOf("=") + 1;
//                genero = datosPelicula[1].substring(indiceInicial);
//
//                indiceInicial = datosPelicula[2].indexOf("=") + 1;
//                indiceFinal = datosPelicula[2].indexOf("}");
//                precio = Double.parseDouble(datosPelicula[2].substring(
//                        indiceInicial, indiceFinal));
                for (int i = 0; i < arrayLectura.length; i++) {

                    if (arrayLectura[i] == '=') {
                        i++;
                        capturar = true;
                    } else if (arrayLectura[i] == ',' || arrayLectura[i] == '}') {
                        capturar = false;
                        indice++;
                    }

                    if (capturar) {
                        datosPelicula[indice] += arrayLectura[i];
                    }
                }

                nombre = datosPelicula[0];
                genero = datosPelicula[1];
                precio = Double.parseDouble(datosPelicula[2]);

                Pelicula pelicula = new Pelicula(nombre, genero, precio);
                peliculas.add(pelicula);
//                System.out.println(lectura);
                lectura = entrada.readLine();
            }

            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);

        try ( PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar))) {
            salida.println(pelicula);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            while (lectura != null) {
                if (lectura.substring(lectura.indexOf("=") + 1, lectura.indexOf(","))
                        .equals(buscar)) {

                    return "\nSí se encontro la película";
                }

                lectura = entrada.readLine();
            }

            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return "\nNo se encontro la película";
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter crearArchivo = new PrintWriter(archivo);

            crearArchivo.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("\nEl archivo se ha eliminado");
    }

}
