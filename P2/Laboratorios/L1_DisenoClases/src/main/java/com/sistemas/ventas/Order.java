/*
 * L1: diseño de clases
 */
package com.sistemas.ventas;

import java.util.ArrayList;

/**
 * Created by Bryan on 16/6/2021
 *
 * @author bryan
 */
public class Order {

    //Fields
    private static int orderCounter;

    private int orderID;
    private ArrayList<Computer> computers;
    private int computerCounter;

    //Constructor
    public Order() {
        computers = new ArrayList<Computer>();
        orderID = ++orderCounter;
    }

    //Get-Set
    public static int getOrderCounter() {
        return orderCounter;
    }

    public static void setOrderCounter(int orderCounter) {
        Order.orderCounter = orderCounter;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    public int getComputerCounter() {
        return computerCounter;
    }

    public void setComputerCounter(int computerCounter) {
        this.computerCounter = computerCounter;
    }

    //Methods
    public void addComputer(Computer computer) {
        computers.add(computer);
        computerCounter++;
    }

    public double calculateTotal() {
        return computers.stream().mapToDouble(Computer::getPrice).sum();
    }

    public double discountOrder() {
        if (computerCounter > 2) {
            return calculateTotal() * 0.80;
        } else {
            return calculateTotal();
        }
    }

    public void showOrder() {
        System.out.println("\n------------Orden " + orderID + "--------------");
        computers.forEach(System.out::println);
    }
}
