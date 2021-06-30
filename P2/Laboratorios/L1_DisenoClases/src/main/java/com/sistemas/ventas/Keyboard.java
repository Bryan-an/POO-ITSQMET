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
    private static int keyboardCounter;

    private int keyboardID;

    //Constructor
    public Keyboard(String inputType, String make, double price) {
        super(inputType, make, price);
        this.keyboardID = ++Keyboard.keyboardCounter;
    }

    //get-set
    public static int getKeyboardCounter() {
        return keyboardCounter;
    }

    public static void setKeyboardCounter(int keyboardCounter) {
        Keyboard.keyboardCounter = keyboardCounter;
    }

    public int getKeyboardID() {
        return keyboardID;
    }

    public void setKeyboardID(int keyboardID) {
        this.keyboardID = keyboardID;
    }

    //toString
    @Override
    public String toString() {
        return "Teclado{" + "TecladoID = " + keyboardID + super.toString();
    }

}
