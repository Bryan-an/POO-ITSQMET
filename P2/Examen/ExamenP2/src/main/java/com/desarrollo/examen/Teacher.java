/*
 * Examen P2
 */
package com.desarrollo.examen;

import java.text.DecimalFormat;

/**
 *
 * @author Bryan Andagoya
 */
public abstract class Teacher {

    //Fields
    protected String name;
    protected String lastname;
    protected String idNumber;
    protected TeacherType type;
    protected double hoursWorked;
    protected double hourlyPay;
    protected double salary;
    protected String salaryWithDiscount;
    protected double discount;

    DecimalFormat formatter = new DecimalFormat("0.00");

    //Constructors
    /**
     * Void constructor of the Teacher class.
     */
    public Teacher() {

    }

    /**
     * Cosntructor of the Teacher class.
     *
     * @param name The name of the teacher.
     * @param lastname The last name of the teacher.
     * @param idNumber The id number of the teacher.
     * @param type The type of the teacher.
     * @param hoursWorked The hours worked by the teacher.
     */
    public Teacher(String name, String lastname, String idNumber,
            TeacherType type, double hoursWorked) {

        this.name = name;
        this.lastname = lastname;
        this.idNumber = idNumber;
        this.type = type;
        this.hoursWorked = hoursWorked;
    }

    //get-set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public TeacherType getType() {
        return type;
    }

    public void setType(TeacherType type) {
        this.type = type;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSalaryWithDiscount() {
        return salaryWithDiscount;
    }

    public void setSalaryWithDiscount(String salaryWithDiscount) {
        this.salaryWithDiscount = salaryWithDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(DecimalFormat formatter) {
        this.formatter = formatter;
    }

    //Methods
    /**
     * Method that calculates the salary of the teacher.
     */
    public void calculateSalary() {
        salary = hoursWorked * hourlyPay;
        applyDiscount();
    }

    /**
     * Method that checks if the tacher has discount.
     *
     * @return Return true if the teacher has discount.
     */
    public abstract boolean hasDiscount();

    /**
     * Method that applies the discount.
     */
    public abstract void applyDiscount();

    /**
     * toString() method.
     *
     * @return The information of the teacher.
     */
    @Override
    public String toString() {
        return "Docente {" + "Nombre: " + name + "; Apellido: " + lastname
                + "; CI: " + idNumber + "; Tipo de docente: " + type
                + "; Horas trabajadas: " + hoursWorked + "; Sueldo: $ "
                + formatter.format(salary) + "; Sueldo con descuento: "
                + salaryWithDiscount + '}';
    }

}
