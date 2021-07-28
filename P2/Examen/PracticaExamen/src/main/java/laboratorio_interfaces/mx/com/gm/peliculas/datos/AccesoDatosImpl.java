/*
 * Laboratorio interfaces
 */
package laboratorio_interfaces.mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import laboratorio_interfaces.mx.com.gm.peliculas.domain.Pelicula;

/**
 *
 * @author Bryan Andagoya
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File("src/main/java/laboratorio_interfaces/mx/com/gm/peliculas/datos/"
                + nombreArchivo + ".txt");

        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
        File archivo
                = new File("src/main/java/laboratorio_interfaces/mx/com/gm/peliculas/datos/"
                        + nombre + ".txt");

        String nombrePelicula;

        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            nombrePelicula = lectura.readLine();

            while (nombrePelicula != null) {
                listaPeliculas.add(new Pelicula(nombrePelicula));
                nombrePelicula = lectura.readLine();
            }

            return listaPeliculas;
        } catch (IOException ex) {
            System.out.println("\nError al leer el archivo");
            return null;
        }

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File("src/main/java/laboratorio_interfaces/mx/com/gm/peliculas/datos/"
                + nombreArchivo + ".txt");

        PrintWriter escritura = null;

        try {
            if (anexar) {
                escritura = new PrintWriter(new FileWriter(archivo, true));
            } else {
                escritura = new PrintWriter(archivo);
            }

            escritura.println(pelicula.getNombre());

        } catch (IOException e) {
            System.out.println("\nError al escribir en el archivo");
        } finally {
            if (escritura != null) {
                escritura.close();
            }
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        File archivo = new File("src/main/java/laboratorio_interfaces/mx/com/gm/peliculas/datos/"
                + nombreArchivo + ".txt");
        String nombrePelicula;

        try (BufferedReader lectura = new BufferedReader(new FileReader(archivo))) {
            nombrePelicula = lectura.readLine();

            while (nombrePelicula != null) {
                if (nombrePelicula.equals(buscar)) {
                    return nombrePelicula;
                }
                nombrePelicula = lectura.readLine();
            }

        } catch (IOException ex) {
            System.out.println("\nError al buscar en el archivo");
        }

        return null;
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File("src/main/java/laboratorio_interfaces/mx/com/gm/peliculas/datos/"
                + nombreArchivo + ".txt");

        try {
            if (archivo.exists()) {
                System.out.println("\nEl archivo ya existe");
            } else {
                archivo.createNewFile();
                System.out.println("\nEl archivo se ha creado correctamente");
            }
        } catch (IOException ex) {
            System.out.println("Error al crar el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File("src/main/java/laboratorio_interfaces/mx/com/gm/peliculas/datos/"
                + nombreArchivo + ".txt");

        if (archivo.delete()) {
            System.out.println("\nEl archivo se borró correctamente");
        } else {
            System.out.println("\nError al borrar el archivo");
        }
    }

}
