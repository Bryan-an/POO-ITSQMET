/*
 * Examen P2
 */
package com.desarrollo.examen;

/**
 *
 * @author Bryan Andagoya
 */
public final class AdministrativeTeacher extends Teacher {

    //Fields
    private static int teachersWithDiscount = 0;

    /**
     * Cosntructor of the AdministrativeTeacher class.
     *
     * @param name The name of the teacher.
     * @param lastname The last name of the teacher.
     * @param idNumber The id number of the teacher.
     * @param type The type of the teacher.
     * @param hoursWorked The hours worked by the teacher.
     */
    public AdministrativeTeacher(String name, String lastname, String idNumber,
            TeacherType type, double hoursWorked) {

        super(name, lastname, idNumber, type, hoursWorked);
        hourlyPay = 9d;
        discount = 0.95;
        calculateSalary();
    }

    //get-set
    public static int getTeachersWithDiscount() {
        return teachersWithDiscount;
    }

    public static void setTeachersWithDiscount(int teachersWithDiscount) {
        AdministrativeTeacher.teachersWithDiscount = teachersWithDiscount;
    }

    //Methods
    /**
     * Method that checks if the tacher has discount.
     *
     * @return Return true if the teacher has discount.
     */
    @Override
    public boolean hasDiscount() {
        return hoursWorked < 160;
    }

    /**
     * Method that applies the discount.
     */
    @Override
    public void applyDiscount() {
        if (hasDiscount()) {
            salaryWithDiscount = "$ " + formatter.format(salary * discount);
            AdministrativeTeacher.teachersWithDiscount++;
        } else {
            salaryWithDiscount = "Usted no a obtenido un descuento";
        }
    }
}
