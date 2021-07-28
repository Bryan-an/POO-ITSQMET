/*
 * Ejercicio de practica empresa RelsB
 */
package com.desarrollo.empresa_relsb;

import java.text.DecimalFormat;

/**
 *
 * @author Bryan Andagoya
 */
public abstract class Client {

    //Fields
    protected String name;
    protected String identification;
    protected ClientType clientType;
    protected double bill;
    protected String billWithDiscount;

    protected DecimalFormat formatter = new DecimalFormat("0.00");

    //Cosntructors
    /**
     * The void constructor of the Client abstract class.
     */
    public Client() {
    }

    /**
     * Contructor of the Client abstract class.
     *
     * @param name The name of the client.
     * @param identification The number identification of the client.
     * @param clientType The type of the client.
     * @param bill The bill of the client.
     */
    public Client(String name, String identification, ClientType clientType,
            double bill) {

        this.name = name;
        this.identification = identification;
        this.clientType = clientType;
        this.bill = bill;

        applyDiscount();
    }

    //get-set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getBillWithDiscount() {
        return billWithDiscount;
    }

    public void setBillWithDiscount(String billWithDiscount) {
        this.billWithDiscount = billWithDiscount;
    }

    //Methods
    /**
     * Method that checks if the client has discount.
     *
     * @return Returns true if the client has discount.
     */
    protected boolean hasDiscount() {
        return bill >= 1800 && bill <= 2500;
    }

    /**
     * Method that applies the discount.
     */
    public abstract void applyDiscount();

    /**
     * Method toString.
     *
     * @return The client information.
     */
    @Override
    public String toString() {
        return "Cliente {" + "Nombre: " + name + "; CI: " + identification
                + "; Tipo de cliente: " + clientType
                + "; Compra sin descuento: $ " + formatter.format(bill) + "; "
                + billWithDiscount + '}';
    }
}
