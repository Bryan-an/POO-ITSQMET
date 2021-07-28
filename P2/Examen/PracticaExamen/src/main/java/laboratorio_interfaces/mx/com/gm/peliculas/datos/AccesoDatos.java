/*
 * Laboratorio interfaces
 */
package laboratorio_interfaces.mx.com.gm.peliculas.datos;

import java.io.File;
import java.util.*;
import laboratorio_interfaces.mx.com.gm.peliculas.domain.Pelicula;

/**
 *
 * @author Bryan Andagoya
 */
public interface AccesoDatos {

    boolean existe(String nombreArchivo);

    List<Pelicula> listar(String nombre);

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);

    String buscar(String nombreArchivo, String buscar);

    void crear(String nombreArchivo);

    void borrar(String nombreArchivo);
}
