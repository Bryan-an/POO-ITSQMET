/*
 * D2: clases abstractas
 */
package com.desarrollo.customers;

import java.text.DecimalFormat;

/**
 *
 * @author Bryan Andagoya
 */
public abstract class Customer {

    //Fields
    protected String name;
    protected long identityNumber;
    protected CustomerType customerType;
    protected double totalToPay;
    protected String totalToPayWithDiscount;
    protected DecimalFormat formatter = new DecimalFormat("0.00");

    /**
     * Constructor of Customer class.
     *
     * @param name The name of the customer.
     * @param identityNumber The identity number of the customer.
     * @param customerType The type of the customer.
     * @param totalToPay The total to pay of the customer.
     */
    public Customer(String name, long identityNumber, CustomerType customerType, double totalToPay) {
        this.name = name;
        this.identityNumber = identityNumber;
        this.customerType = customerType;
        this.totalToPay = totalToPay;
    }

    //Get-Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public String getTotalToPayWithDiscount() {
        return totalToPayWithDiscount;
    }

    public void setTotalToPayWithDiscount(String totalToPayWithDiscount) {
        this.totalToPayWithDiscount = totalToPayWithDiscount;
    }

    /**
     * Method that returns the data of the customer.
     *
     * @return The data of the custumer.
     */
    @Override
    public String toString() {
        return "Cliente " + customerType + " {nombre: " + name + "; cédula: " + identityNumber
                + "; tipo de cliente: Cliente " + customerType
                + "; total a pagar: $ " + formatter.format(totalToPay)
                + "; total a pagar con descuento: " + totalToPayWithDiscount
                + '}';
    }

    /**
     * Method that applies the discount ot the total to pay.
     */
    public abstract void applyDiscount();

}
