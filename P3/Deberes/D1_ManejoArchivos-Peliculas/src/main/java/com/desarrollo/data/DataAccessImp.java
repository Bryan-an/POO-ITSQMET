/*
 * D1: Files management
 */
package com.desarrollo.data;

import com.desarrollo.domain.Movie;
import java.io.*;
import java.util.*;

/**
 *
 * @author Bryan Andagoya
 */
public class DataAccessImp implements DataAccess {

    //Implemented methods
    @Override
    public boolean exists(String fileName) {
        return new File(fileName).exists();
    }

    @Override
    public List<Movie> list(String fileName) {
        File file = new File(fileName);
        List<Movie> movies = new ArrayList<Movie>();
        String data;

        try ( BufferedReader input = new BufferedReader(new FileReader(file))) {

            while ((data = input.readLine()) != null) {
                char[] dataArray = data.toCharArray();
                boolean catchChars = false;
                int index = 0;
                String[] movieData = {"", "", ""};

                for (int i = 0; i < dataArray.length; i++) {

                    if (dataArray[i] == '=') {
                        i += 2;
                        catchChars = true;
                    } else if (dataArray[i] == ';' || dataArray[i] == '}') {
                        catchChars = false;
                        index++;
                    }

                    if (catchChars) {
                        movieData[index] += dataArray[i];
                    }
                }

                String name = movieData[0];
                String genre = movieData[1];
                double price = Double.parseDouble(movieData[2]);

                movies.add(new Movie(name, genre, price));
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return movies;
    }

    @Override
    public void write(Movie movie, String fileName, boolean append) {
        File file = new File(fileName);

        try ( PrintWriter output = new PrintWriter(new FileWriter(file, append))) {

            output.println(movie);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String search(String fileName, String movieName) {
        File file = new File(fileName);
        String data;

        try ( BufferedReader input = new BufferedReader(new FileReader(file))) {

            while ((data = input.readLine()) != null) {
                if (data.substring(data.indexOf("=") + 2, data.indexOf(";"))
                        .equals(movieName)) {

                    return "\nPelícula encontrada";
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return "\nNo se encontró la película";
    }

    @Override
    public void create(String fileName) {

        File file = new File(fileName);

        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public boolean remove(String fileName) {
        File file = new File(fileName);
        return file.delete();
    }

    @Override
    public boolean edit(String fileName, String oldName, String newName,
            String newGenre, double newPrice) {

        File file = new File(fileName);
        List<Movie> movies = list(fileName);
        boolean edited = false;

        for (Movie movie : movies) {
            if (movie.getName().equals(oldName)) {
                movie.setName(newName);
                movie.setGenre(newGenre);
                movie.setPrice(newPrice);
                edited = true;
                break;
            }
        }

        if (edited) {
            file.delete();
            movies.forEach(m -> write(m, fileName, true));
        }

        return edited;
    }

    @Override
    public boolean delete(String fileName, String movieName) {
        File file = new File(fileName);
        List<Movie> movies = list(fileName);
        boolean deleted = false;

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName)) {
                movies.remove(i);
                deleted = true;
                break;
            }
        }

        if (deleted) {
            file.delete();
            movies.forEach(movie -> write(movie, fileName, true));
        }

        return deleted;
    }

}
