/*
 * Ejercicio de practica empresa RelsB
 */
package com.desarrollo.empresa_relsb;

/**
 *
 * @author Bryan Andagoya
 */
public class ClientB extends Client {

    /**
     * Contructor of the ClientB class.
     *
     * @param name The name of the client.
     * @param identification The number identification of the client.
     * @param clientType The type of the client.
     * @param bill The bill of the client.
     */
    public ClientB(String name, String identification, ClientType clientType,
            double bill) {

        super(name, identification, clientType, bill);
    }

    /**
     * Method that applies the discount.
     */
    @Override
    public void applyDiscount() {
        if (hasDiscount()) {
            billWithDiscount = "Compra con descuento = $ "
                    + formatter.format(bill * 0.90);

        } else {
            billWithDiscount = "Usted no ha recibido descuento";
        }
    }
}
