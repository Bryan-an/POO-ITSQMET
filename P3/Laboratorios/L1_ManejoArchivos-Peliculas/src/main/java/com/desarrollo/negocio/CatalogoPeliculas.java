/*
 * Manejo de archivos
 */
package com.desarrollo.negocio;

/**
 *
 * @author Bryan Andagoya
 */
public interface CatalogoPeliculas {

    void inciciarArchivo(String nombreArchivo);

    void agregarPelicula(String nombre, String genero, double precio,
            String nombreArchivo);

    void listarPeliculas(String nombreArchivo);

    void buscarPelicula(String nombreArchivo, String buscar);

    void editarPelicula(String nombre, String genero, double precio,
            String nombreArchivo, String nombreEditar);
}
