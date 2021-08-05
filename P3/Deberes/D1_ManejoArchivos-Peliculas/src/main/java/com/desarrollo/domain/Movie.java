/*
 * D1: Files management
 */
package com.desarrollo.domain;

/**
 *
 * @author Bryan Andagoya
 */
public class Movie {

    //Fields
    private String name;
    private String genre;
    private double price;

    //Constructors
    public Movie() {
    }

    public Movie(String name, String genre, double price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    //get-set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //toString()
    @Override
    public String toString() {
        return "Pelicula {"
                + "nombre = " + name
                + "; genero = " + genre
                + "; precio = " + price + '}';
    }

}
