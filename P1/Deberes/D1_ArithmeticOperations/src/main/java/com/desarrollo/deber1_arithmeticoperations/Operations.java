/**
 * Created by Bryan on 28/04/2021
 */
package com.desarrollo.deber1_arithmeticoperations;

/**
 *
 * @author bryan
 */
public class Operations {

    /**
     * Method that performs the sum.
     *
     * @param num1 Number 1.
     * @param num2 Number 2.
     * @return The result of the sum.
     */
    public static String addNumbers(double num1, double num2) {
        return "\nLa suma es: " + (num1 + num2);
    }

    /**
     * Method that performs the subtraction.
     *
     * @param num1 Number 1.
     * @param num2 Number 2.
     * @return The result of the subtraction.
     */
    public static String subtractNumbers(double num1, double num2) {
        return "\nLa resta es: " + (num1 - num2);
    }

    /**
     * Method that performs the multiplication.
     *
     * @param num1 Number 1.
     * @param num2 Number 2.
     * @return The result of the multiplication.
     */
    public static String multiplyNumbers(double num1, double num2) {
        return "\nEl producto es: " + (num1 * num2);
    }

    /**
     * Method that performs the division.
     *
     * @param num1 Number 1.
     * @param num2 Number 2.
     * @return The result of the division.
     */
    public static String divideNumbers(double num1, double num2) {
        if (num1 == 0 && num2 == 0) {
            return "\nIndeterminación";
        } else if (num2 == 0) {
            return "\nNo existe la división para cero";
        } else {
            return "\nEl cociente es: " + (num1 / num2);
        }
    }

}
