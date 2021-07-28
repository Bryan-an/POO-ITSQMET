/*
 * Laboratorio interfaces
 */
package laboratorio_interfaces.cpjlaboratoriofinal;

import java.util.*;
import laboratorio_interfaces.mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import static input.AskData.*;
import java.util.function.Predicate;

/**
 *
 * @author Bryan Andagoya
 */
public class CPJLaboratorioFinal {

    Scanner input = new Scanner(System.in);
    int opcion;
    String nombreArchivo;
    CatalogoPeliculas catalogoPeliculas;

    public static void main(String[] args) {
        new CPJLaboratorioFinal().desplegarMenu();
    }

    public void desplegarMenu() {
        String solicitud = "\nElige una opción:"
                + "\n\n1. Iniciar catalogo peliculas"
                + "\n2. Agregar pelicula"
                + "\n3. Listar Peliculas"
                + "\n4. Buscar Pelicula"
                + "\n0. Salir";

        Predicate<Integer> filtro = n -> n >= 0 && n <= 4;
        String MensajeError = "\nOpción inválida, intente de nuevo";

        do {
            opcion = askInt(solicitud, filtro, MensajeError);
            realizarOperaciones(opcion);
        } while (opcion != 0);

    }

    public void realizarOperaciones(int opcion) {
        switch (opcion) {
            case 1 ->
                iniciarCatalogo();
            case 2 ->
                agregarPelicula();
            case 3 ->
                listarPeliculas();
            case 4 ->
                buscarPelicula();
            case 0 ->
                System.out.println("\nGracias por utilizar nuestro programa");
        }
    }
    
    public void iniciarCatalogo(){
        
    }
    
    public void agregarPelicula(){
        
    }
    
    public void listarPeliculas(){
        
    }
    
    public void buscarPelicula(){
        
    }
}
