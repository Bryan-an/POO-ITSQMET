/*
 * Laboratorio interfaces
 */
package laboratorio_interfaces.mx.com.gm.peliculas.negocio;

import laboratorio_interfaces.mx.com.gm.peliculas.datos.AccesoDatos;

/**
 *
 * @author Bryan Andagoya
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    //Campos
    AccesoDatos datos;

    public CatalogoPeliculasImpl() {
    }

    //Methods
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo) {

    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
    }

}
