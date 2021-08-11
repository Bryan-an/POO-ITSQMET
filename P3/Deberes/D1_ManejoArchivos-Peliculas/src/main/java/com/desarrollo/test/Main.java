/*
 * D1: Files management
 */
package com.desarrollo.test;

import com.desarrollo.business.*;
import static input.AskForData.*;
import java.util.function.Predicate;

/**
 *
 * @author Bryan Andagoya
 */
public class Main {

    //Fields
    private final MovieCatalog catalog = new MovieCatalogImp();
    String fileName = "src/main/java/com/desarrollo/db/movies.txt";

    /**
     * Main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().displayMenu();
    }

    /**
     * Method that displays the menu.
     */
    public void displayMenu() {
        int optionNumber;
        String request = "\n-----------Menú películas desarrollo------------"
                + "\n1. Iniciar archivo"
                + "\n2. Agregar película"
                + "\n3. Listar películas"
                + "\n4. Buscar película"
                + "\n5. Eliminar archivo"
                + "\n6. Editar película"
                + "\n7. Eliminar película"
                + "\n8. Salir"
                + "\n\nEscoja una opción: ";

        Predicate<Integer> filter = n -> n >= 1 && n <= 8;
        String errorMessage = "\nOpción inválida, intente de nuevo";

        do {
            optionNumber = askForInt(request, filter, errorMessage);

            performOperations(optionNumber);
        } while (optionNumber != 8);

    }

    /**
     * Method that perfrom the operations.
     *
     * @param optionNumber The option number.
     */
    public void performOperations(int optionNumber) {
        switch (optionNumber) {
            case 1 ->
                catalog.createFile(fileName);
            case 2 ->
                addMovie();
            case 3 ->
                catalog.listMovies(fileName);
            case 4 ->
                searchMovie();
            case 5 ->
                catalog.removeFile(fileName);
            case 6 ->
                editMovie();
            case 7 ->
                deleteMovie();
            case 8 ->
                System.out.println("\nGracias por utilizar nuestro programa");
        }
    }

    /**
     * Method that adds a movie to the file.
     */
    public void addMovie() {
        String name = askForMovieName("\nIngrese el nombre de la película: ");
        String genre = askForMovieGenre("\nIngrese el género de la película: ");
        double price = askForMoviePrice("\nIngrese el precio de la película: ");

        catalog.addMovie(name, genre, price, fileName);
    }

    /**
     * Method that asks for the name of the movie.
     *
     * @param request The request for the user.
     * @return The name of the movie.
     */
    public String askForMovieName(String request) {
        return askForString(request);
    }

    /**
     * Method that asks for the genre of the movie.
     *
     * @param request The request for the user.
     * @return The genre of the movie.
     */
    public String askForMovieGenre(String request) {
        return askForString(request);
    }

    /**
     * Method that asks for the price of the movie.
     *
     * @param request The request for the user.
     * @return The price of the movie.
     */
    public double askForMoviePrice(String request) {
        Predicate<String> filter = n -> n.matches("\\d+\\.?\\d{0,2}");
        String errorMessage = "\nPrecio inválido, intente de nuevo";

        return Double.parseDouble(askForString(request, filter, errorMessage));
    }

    /**
     * Method that searchs a movie in the file.
     */
    public void searchMovie() {
        String movieName = askForMovieName("\nIngrese el nombre de la película: ");

        catalog.searchMovie(fileName, movieName);
    }

    /**
     * Method that edits a movie from the file.
     */
    public void editMovie() {
        String oldName = askForMovieName(
                "\nIngrese el nombre de la película a modificar: ");

        String newName = askForMovieName("\nIngrese el nuevo nombre de la película");
        String newGenre = askForMovieName("\nIngrese el nuevo género de la película");
        double newPrice = askForMoviePrice("\nIngrese el nuevo precio de la película");

        catalog.editMovie(fileName, oldName, newName, newGenre, newPrice);
    }

    /**
     * Method that deletes a movie from the file.
     */
    public void deleteMovie() {
        String movieName = askForMovieName("\nIngrese el nombre de la película: ");

        catalog.deleteMovie(fileName, movieName);
    }

}
