/*
 * Generar objetos a partir de los registros de la BDD
 */
package com.desarrollo.domain;

/**
 *
 * @author Bryan Andagoya
 */
public class PersonaDTO {

    private int idPersona;
    private String nombre;
    private String apellido;
    private int edad;
    private int telefono;
    private String email;

    //constructores - operaciones BDD
    //delete
    public PersonaDTO(int idPersona) {
        this.idPersona = idPersona;
    }

    //insert
    public PersonaDTO(String nombre, String apellido, int edad, int telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
    }

    //update-select
    public PersonaDTO(int idPersona, String nombre, String apellido, int edad, int telefono, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
    }

    //get-set
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", telefono=" + telefono + ", email=" + email + '}';
    }

}
