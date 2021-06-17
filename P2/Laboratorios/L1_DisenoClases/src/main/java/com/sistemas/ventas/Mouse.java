/*
 * L1: deseño de clases
 */
package com.sistemas.ventas;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class Mouse extends InputDevices {

    //Fields
    private static int mouseCounter;

    private int mouseID;

    //Constructor
    public Mouse(String inputType, String make, double price) {
        super(inputType, make, price);
        mouseID = ++mouseCounter;
    }

    //toString
    @Override
    public String toString() {
        return "Mouse{" + "MouseID = " + mouseID + super.toString();
    }

}
