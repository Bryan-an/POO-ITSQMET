/*
 * Examen P2
 */
package com.desarrollo.examen;

/**
 *
 * @author Bryan Andagoya
 */
public final class HourlyTeacher extends Teacher {

    //Fields
    private static int teachersWithDiscount = 0;

    /**
     * Cosntructor of the HourlyTeacher class.
     *
     * @param name The name of the teacher.
     * @param lastname The last name of the teacher.
     * @param idNumber The id number of the teacher.
     * @param type The type of the teacher.
     * @param hoursWorked The hours worked by the teacher.
     */
    public HourlyTeacher(String name, String lastname, String idNumber,
            TeacherType type, double hoursWorked) {

        super(name, lastname, idNumber, type, hoursWorked);
        hourlyPay = 7.50;
        discount = 0.94;
        calculateSalary();
    }

    //get-set
    public static int getTeachersWithDiscount() {
        return teachersWithDiscount;
    }

    public static void setTeachersWithDiscount(int teachersWithDiscount) {
        HourlyTeacher.teachersWithDiscount = teachersWithDiscount;
    }

    //Methods
    /**
     * Method that checks if the tacher has discount.
     *
     * @return Return true if the teacher has discount.
     */
    @Override
    public boolean hasDiscount() {
        return hoursWorked < 80;
    }

    /**
     * Method that applies the discount.
     */
    @Override
    public void applyDiscount() {
        if (hasDiscount()) {
            salaryWithDiscount = "$ " + formatter.format(salary * discount);
            HourlyTeacher.teachersWithDiscount++;
        } else {
            salaryWithDiscount = "Usted no a obtenido un descuento";
        }
    }
}
