/*
 * Modificadores de acceso
 */
package com.desarrollo.paquete1;

/**
 *
 * @author Bryan Andagoya
 */
public class Clase1 {

    //Atributos con modificadores
    public String atributoPublico = "Valor Público";
    protected String atributoProtegido = "Valor Protegido";
    String atributoDefault = "Valor Default";
    private String atributoPrivado = "Valor Privado";

    //constructores con modificadores
    public Clase1(String texto) {
        System.out.println("Constructor público: " + texto);
    }

    protected Clase1(int entero) {
        System.out.println("Constructor protegido: " + entero);
    }

    Clase1(double decimal) {
        System.out.println("Constructor default: " + decimal);
    }

    private Clase1(char caracter) {
        System.out.println("Constructor privado: " + caracter);
    }

    //Métodos con modificadores 
    public void metodoPublico() {
        System.out.println("Método público");
    }

    protected void metodoProtegido() {
        System.out.println("Método protegido");
    }

    void metodoDefault() {
        System.out.println("Método default");
    }

    private void metodoPrivado() {
        System.out.println("Método privado");
    }
}
