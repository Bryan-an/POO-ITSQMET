/*
 * Manejo de archivos
 */
package com.desarrollo.negocio;

import com.desarrollo.datos.*;
import com.desarrollo.domain.*;
import java.util.List;

/**
 *
 * @author Bryan Andagoya
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    AccesoDatos bdd = new AccesoDatosImpl();

    @Override
    public void inciciarArchivo(String nombreArchivo) {
        if (bdd.existe(nombreArchivo)) {
            System.out.println("El archivo ya existe!");
        } else {
            bdd.crear(nombreArchivo);
            System.out.println("El archivo se ha creado correctamente!");
        }
    }

    @Override
    public void agregarPelicula(String nombre, String genero, double precio,
            String nombreArchivo) {

        Pelicula pelicula = new Pelicula(nombre, genero, precio);
        bdd.escribir(pelicula, nombreArchivo, true);
        System.out.println("Se ha agregado correctamente la película");
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        //capturar el método listar-retorna una lista
        List<Pelicula> peliculas = bdd.listar(nombreArchivo);
        System.out.println("\nInformación películas");
        System.out.printf("%-30s %-30s %-30s \n", "Nombre", "Género", "Precio");
        System.out.println();
        peliculas.forEach(pelicula -> System.out.printf("%-30s %-30s %-30s \n",
                pelicula.getNombre(),
                pelicula.getGenero(),
                pelicula.getPrecio()));
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        System.out.println(bdd.buscar(nombreArchivo, buscar));
    }

}
