/*
 * Corrección del L1: Diseño de clases
 */
package com.desarrllo.ventas;

/**
 *
 * @author bryan
 */
public class Raton extends DispositivosEntrada {

    private int idRaton;
    private static int contRaton = 0;

    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idRaton = ++contRaton;
    }

    //get-set
    public int getIdRaton() {
        return idRaton;
    }

    public void setIdRaton(int idRaton) {
        this.idRaton = idRaton;
    }

    public static int getContRaton() {
        return contRaton;
    }

    public static void setContRaton(int contRaton) {
        Raton.contRaton = contRaton;
    }

    //toString
    @Override
    public String toString() {
        return "Raton{" + "idRaton=" + idRaton + super.toString() + '}';
    }

}
