/*
 * D1: Files management
 */
package com.desarrollo.business;

/**
 *
 * @author Bryan Andagoya
 */
public interface MovieCatalog {

    /**
     * Method that creates the file.
     *
     * @param fileName The name of the file.
     */
    void createFile(String fileName);

    /**
     * Method that adds a movie to the file.
     *
     * @param name The name of the movie.
     * @param genre The genre of the genre.
     * @param price The price of the movie.
     * @param fileName The namme of the file.
     */
    void addMovie(String name, String genre, double price, String fileName);

    /**
     * Method that lists the movies from the file.
     *
     * @param fileName The name of the file.
     */
    void listMovies(String fileName);

    /**
     * Method that searchs a movie in the file.
     *
     * @param fileName The name of the file.
     * @param movieName The name of the movie.
     */
    void searchMovie(String fileName, String movieName);

    /**
     * Method that removes the file.
     *
     * @param fileName The name of the file.
     */
    void removeFile(String fileName);

    /**
     * Method that edit a movie from the file.
     *
     * @param fileName The name of the file.
     * @param oldName The current name of the movie.
     * @param newName The new name of the movie.
     * @param newGenre The new genre of the movie.
     * @param newPrice The new price of the movie.
     */
    void editMovie(String fileName, String oldName, String newName,
            String newGenre, double newPrice);

    /**
     * Method that deletes a movie from the file.
     *
     * @param fileName The name of the file.
     * @param movieName The name of the movie.
     */
    void deleteMovie(String fileName, String movieName);

}
