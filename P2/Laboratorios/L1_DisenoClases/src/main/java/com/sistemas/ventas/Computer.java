/*
 * L1: diseño de clases
 */
package com.sistemas.ventas;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class Computer {

    //Fields
    private static int computerCounter;

    private String make;
    private Monitor monitor;
    private Keyboard keyboard;
    private Mouse mouse;
    private double price;
    private int computerID;

    //Constructors
    private Computer() {
        computerID = ++computerCounter;
    }

    public Computer(String make, Monitor monitor, Keyboard keyboard, Mouse mouse) {
        this();
        this.make = make;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.price = Math.round((monitor.getPrice() + keyboard.getPrice()
                + mouse.getPrice()) * 100.0) / 100.0;
    }

    //Get-Set
    public static int getComputerCounter() {
        return computerCounter;
    }

    public static void setComputerCounter(int computerCounter) {
        Computer.computerCounter = computerCounter;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getComputerID() {
        return computerID;
    }

    public void setComputerID(int computerID) {
        this.computerID = computerID;
    }

    //toString
    @Override
    public String toString() {
        return "Computadora{\nComputadoraID: " + computerID + "\nMarca: " + make
                + "\nMonitor: " + monitor + "\nTeclado: " + keyboard
                + "\nRatón: " + mouse + "\nPrecio: $"
                + (Math.round(price * 100.0) / 100.0) + "}\n";
    }

}
