/*
 * Manejo de archivos
 */
package com.desarrollo.datos;

import com.desarrollo.domain.Pelicula;
import java.util.List;

/**
 *
 * @author Bryan Andagoya
 */
public interface AccesoDatos {

    boolean existe(String nombreArchivo);

    List<Pelicula> listar(String nombreArchivo);

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);

    String buscar(String nombreArcivo, String buscar);

    void crear(String nombreArchivo);

    void borrar(String nombreArchivo);

    void editar(Pelicula pelicula, String nombreArchivo, String nombreEditar);

}
