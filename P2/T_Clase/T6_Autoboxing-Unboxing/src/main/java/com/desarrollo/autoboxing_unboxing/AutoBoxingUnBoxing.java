/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.autoboxing_unboxing;

/**
 *
 * @author Bryan Andagoya
 */
public class AutoBoxingUnBoxing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Autoboxing
        //Integer, Float, Double, Character, Boolean, Byte, Short, Long
        Integer numObject = 10;
        System.out.println("Valor num: " + numObject);
        System.out.println("Valor num decimal: " + numObject.doubleValue());

        //Unboxing
        int numPrimitivo = numObject;
        System.out.println("Valor num: " + numPrimitivo);
    }

}
