/*
 * Exam training.
 */
package com.desarrollo.examtraining;

/**
 *
 * @author bryan
 */
public class Nonperishable extends Product {

    //Fields 
    private String type;

    //Constructor
    public Nonperishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }
    
    //Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    //MethodsF

    @Override
    public String toString() {
        return "No perecedero: "+ super.toString() + "; tipo = " + type;
    }
    
    
}
