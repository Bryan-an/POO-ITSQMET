/*
 * D1: Files management
 */
package com.desarrollo.business;

import com.desarrollo.data.*;
import com.desarrollo.domain.Movie;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Bryan Andagoya
 */
public class MovieCatalogImp implements MovieCatalog {

    //Fields
    DataAccess db = new DataAccessImp();

    //Implemented methods
    @Override
    public void createFile(String fileName) {
        if (db.exists(fileName)) {
            System.out.println("\nEl archivo ya existe");
        } else {
            db.create(fileName);
            System.out.println("\nEl archivo se ha creado correctamente");
        }
    }

    @Override
    public void addMovie(String name, String genre, double price, String fileName) {
        Movie movie = new Movie(name, genre, price);
        db.write(movie, fileName, true);
        System.out.println("\nSe ha agregado correctamente la película");
    }

    @Override
    public void listMovies(String fileName) {
        List<Movie> movies = db.list(fileName);

        if (movies.isEmpty()) {
            System.out.println("\nAún no se registra ninguna película");
        } else {
            System.out.println();
            System.out.println(StringUtils.repeat("-", 94));
            System.out.printf("|%-92s|\n", "Información películas");
            System.out.println(StringUtils.repeat("-", 94));
            System.out.printf("|%-30s|%-30s|%-30s|\n", "Nombre", "Género", "Precio");
            System.out.println(StringUtils.repeat("-", 94));
            movies.forEach(movie -> System.out.printf("|%-30s|%-30s|%-30s|\n",
                    movie.getName(),
                    movie.getGenre(),
                    "$ " + movie.getPrice()));
            System.out.println(StringUtils.repeat("-", 94));
        }
    }

    @Override
    public void searchMovie(String fileName, String movieName) {
        System.out.println(db.search(fileName, movieName));
    }

    @Override
    public void removeFile(String fileName) {
        if (db.remove(fileName)) {
            System.out.println("\nEl archivo se elimino correctamente");
        } else {
            System.out.println("\nNo se encontró el archivo");
        }
    }

    @Override
    public void editMovie(String fileName, String oldName, String newName,
            String newGenre, double newPrice) {

        if (db.edit(fileName, oldName, newName, newGenre, newPrice)) {
            System.out.println("\nLa pelicula se edito correctamente");
        } else {
            System.out.println("\nNo se encontró la película");
        }

    }

    @Override
    public void deleteMovie(String fileName, String movieName) {
        if (db.delete(fileName, movieName)) {
            System.out.println("\nLa película se elmininó correctamente");
        } else {
            System.out.println("\nNo se encontro la película");
        }
    }

}
