/*
 * Exam training
 */
package com.desarrollo.examtraining;

/**
 *
 * @author bryan
 */
public abstract class Product {

    //Fields
    private String name;
    private double price;

    //Constructor
    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Methods
    @Override
    public String toString() {
        return "nombre = " + name + "; precio = " + price;
    }
    
}
