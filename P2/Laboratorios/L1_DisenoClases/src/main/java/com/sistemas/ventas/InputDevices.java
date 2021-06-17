/*
 * L1: diseño de clases
 */
package com.sistemas.ventas;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class InputDevices {

    //Fields
    private String inputType;
    private String make;
    private double price;

    //Constructor
    public InputDevices(String inputType, String make, double price) {
        this.inputType = inputType;
        this.make = make;
        this.price = price;
    }

    //Get-Set
    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //toString
    @Override
    public String toString() {
        return "; Input type = " + inputType + "; Make = " + make + "; Price = $"
                + (Math.round(price * 100.0) / 100.0) + '}';
    }

}
