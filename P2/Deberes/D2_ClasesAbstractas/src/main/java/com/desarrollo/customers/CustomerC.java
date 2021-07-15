/*
 * D2: Clases abstractas
 */
package com.desarrollo.customers;

/**
 *
 * @author Bryan Andagoya
 */
public class CustomerC extends Customer {

    /**
     * Constructor of CustomerB class.
     *
     * @param name The name of the customer.
     * @param identityNumber The identity number of the customer.
     * @param customerType The type of the customer.
     * @param totalToPay The total to pay of the customer.
     */
    public CustomerC(String name, long identityNumber, CustomerType customerType, double totalToPay) {
        super(name, identityNumber, customerType, totalToPay);
    }

    /**
     * Method that applies the discount ot the total to pay.
     */
    @Override
    public void applyDiscount() {
        if (totalToPay >= 1800 && totalToPay <= 2500) {
            totalToPayWithDiscount = "$ " + formatter.format(totalToPay * 0.95);
        } else {
            totalToPayWithDiscount = "Usted no recibió descuento en su compra";
        }
    }

}
