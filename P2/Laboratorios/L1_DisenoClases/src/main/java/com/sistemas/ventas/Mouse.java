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
        this.mouseID = ++Mouse.mouseCounter;
    }

    //get-set
    public static int getMouseCounter() {
        return mouseCounter;
    }

    public static void setMouseCounter(int mouseCounter) {
        Mouse.mouseCounter = mouseCounter;
    }

    public int getMouseID() {
        return mouseID;
    }

    public void setMouseID(int mouseID) {
        this.mouseID = mouseID;
    }

    //toString
    @Override
    public String toString() {
        return "Ratón{" + "RatónID = " + mouseID + super.toString();
    }

}
