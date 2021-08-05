/*
 * D1: Files management
 */
package com.desarrollo.data;

import com.desarrollo.domain.Movie;
import java.util.List;

/**
 *
 * @author Bryan Andagoya
 */
public interface DataAccess {

    /**
     * Method that checks whether the file exists.
     *
     * @param fileName The name of the file.
     * @return true if the file exists.
     */
    boolean exists(String fileName);

    /**
     * Method that lists the movies from the file.
     *
     * @param fileName The name of the file.
     * @return A movie list with the registered movies in the file.
     */
    List<Movie> list(String fileName);

    /**
     * Method that write a movie in the file.
     *
     * @param movie The movie.
     * @param fileName The name of the file.
     * @param append Set as true if you want to append data in the file.
     */
    void write(Movie movie, String fileName, boolean append);

    /**
     * Method that searchs a movie in the file.
     *
     * @param fileName The name of the file.
     * @param movieName The name of the movie.
     * @return The confimation message.
     */
    String search(String fileName, String movieName);

    /**
     * Method that creates the file.
     *
     * @param fileName The name of the file.
     */
    void create(String fileName);

    /**
     * Method that removes the file.
     *
     * @param fileName The name of the file.
     * @return true if the file was removed.
     */
    boolean remove(String fileName);

    /**
     * Method that edit a movie from the file.
     *
     * @param fileName The name of the file.
     * @param oldName The current name of the movie.
     * @param newName The new name of the movie.
     * @param newGenre The new genre of the movie.
     * @param newPrice The new price of the movie.
     * @return true if the movie was edited.
     */
    boolean edit(String fileName, String oldName, String newName,
            String newGenre, double newPrice);

    /**
     * Method that deletes a movie from the file.
     *
     * @param fileName The name of the file.
     * @param movieName The name of the movie.
     * @return true if the movie was deleted.
     */
    boolean delete(String fileName, String movieName);

}
