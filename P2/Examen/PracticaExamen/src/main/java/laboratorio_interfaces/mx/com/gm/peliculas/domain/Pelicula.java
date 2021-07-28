/*
 * Laboratorio interfaces
 */
package laboratorio_interfaces.mx.com.gm.peliculas.domain;

/**
 *
 * @author Bryan Andagoya
 */
public class Pelicula {

    //Campos
    private String nombre;

    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    //get-set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //toString
    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + '}';
    }
    

}
