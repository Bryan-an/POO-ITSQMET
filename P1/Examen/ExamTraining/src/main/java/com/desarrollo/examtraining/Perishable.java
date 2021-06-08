/*
 * Exam training
 */
package com.desarrollo.examtraining;

/**
 *
 * @author bryan
 */
public class Perishable extends Product {

    //Fields
    private int daysExpire;

    //Constructor
    public Perishable(String name, double price, int daysExpire) {
        super(name, price);
        this.daysExpire = daysExpire;
    }

    //Getters and Setters
    public int getDaysExpire() {
        return daysExpire;
    }

    public void setDaysExpire(int daysExpire) {
        this.daysExpire = daysExpire;
    }

    //Methods
    @Override
    public String toString() {
        return "Perecedero: " + super.toString() + "; días a caducar = "
                + daysExpire;
    }

    public void calculatePrice() {
        switch (daysExpire) {
            case 1:
                super.setPrice(super.getPrice() * 0.996);
                break;
            case 2:
                super.setPrice(super.getPrice() * 0.997);
                break;
            case 3:
                super.setPrice(super.getPrice() * 0.998);
                break;
        }
    }

}
