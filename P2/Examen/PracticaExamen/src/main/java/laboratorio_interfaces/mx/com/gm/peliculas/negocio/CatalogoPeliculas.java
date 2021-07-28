/*
 * Laboratorio interfaces
 */
package laboratorio_interfaces.mx.com.gm.peliculas.negocio;

/**
 *
 * @author Bryan Andagoya
 */
public interface CatalogoPeliculas {

    void agregarPeliculas(String nombrePelicula, String nombreArchivo);

    void listarPeliculas(String nombreArchivo);

    void buscarPelicula(String nombreArchivo, String buscar);

    void iniciarArchivo(String nombreArchivo);
}
