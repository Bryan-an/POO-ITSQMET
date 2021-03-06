/*
 * Manejo de archivos
 */
package com.desarrollo.datos;

import com.desarrollo.domain.Pelicula;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Andagoya
 */
public class AccesoDatosImpl implements AccesoDatos {

    private static boolean bandera = false;

    //Verificar si existe el archivo
    @Override
    public boolean existe(String nombreArchivo) {
        return new File(nombreArchivo).exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<Pelicula>();

        try ( BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
            String lectura;

            while ((lectura = entrada.readLine()) != null) {
                char[] arrayLectura = lectura.toCharArray();
                boolean capturar = false;
                int indice = 0;
                String[] datosPelicula = {"", "", ""};
                String nombre;
                String genero;
                double precio;

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
            }

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

        try ( BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
            String lectura;

            while ((lectura = entrada.readLine()) != null) {
                if (lectura.substring(lectura.indexOf("=") + 1, lectura.indexOf(","))
                        .equals(buscar)) {
                    bandera = true;
                    return "\nS?? se encontro la pel??cula";
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return "\nNo se encontro la pel??cula";
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("\nEl archivo se ha eliminado");
    }

    @Override
    public void editar(Pelicula pelicula, String nombreArchivo, String nombreEditar) {
        File archivo = new File(nombreArchivo);
        try {
            //archivo temporal
            File archivoTemporal = new File(archivo.getAbsolutePath() + ".tmp");
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            //Escribir el archivo temporal
            PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal, true));
            String lectura;

            while ((lectura = entrada.readLine()) != null) {
                if (lectura.substring(lectura.indexOf("=") + 1, lectura.indexOf(","))
                        .equals(nombreEditar)) {

                    pw.println(pelicula);
                } else {
                    pw.println(lectura);
                }
            }

            pw.close();
            entrada.close();

            //eliminar archivo original
            archivo.delete();
            //renombrar archivo
            archivoTemporal.renameTo(archivo);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
