/*
 * L1: diseño de clases
 */
package com.sistemas.ventas;

/**
 * Creted by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class Keyboard extends InputDevices {

    //Fields
    private static int mouseCounter;

    private int keyboardID;

    //Constructor
    public Keyboard(String inputType, String make, double price) {
        super(inputType, make, price);
        keyboardID = ++mouseCounter;
    }

    //toString
    @Override
    public String toString() {
        return "Teclado{" + "TecladoID = " + keyboardID + super.toString();
    }

}
