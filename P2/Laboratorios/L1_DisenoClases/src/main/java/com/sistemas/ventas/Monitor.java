/*
 * L1: diseño de clases
 */
package com.sistemas.ventas;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class Monitor {

    //Fields
    private static int monitorCounter;

    private int monitorID;
    private String make;
    private double size;
    private double price;

    //Constructors
    private Monitor() {
        this.monitorID = ++Monitor.monitorCounter;
    }

    public Monitor(String make, double size, double price) {
        this();
        this.make = make;
        this.size = size;
        this.price = price;
    }

    //Get-Set
    public static int getMonitorCounter() {
        return monitorCounter;
    }

    public static void setMonitorCounter(int monitorCounter) {
        Monitor.monitorCounter = monitorCounter;
    }

    public int getMonitorID() {
        return monitorID;
    }

    public void setMonitorID(int monitorID) {
        this.monitorID = monitorID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
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
        return "Monitor{" + "MonitorID = " + monitorID + "; Marca = " + make
                + "; Tamaño = " + size + " cm" + "; Precio = $"
                + (Math.round(price * 100.0) / 100.0) + '}';
    }

}
