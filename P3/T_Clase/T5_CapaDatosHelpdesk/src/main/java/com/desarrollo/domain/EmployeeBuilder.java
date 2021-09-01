package com.desarrollo.domain;

import java.time.LocalDate;

public class EmployeeBuilder {

    private EmployeeDTO employee;

    public EmployeeBuilder() {
        reset();
    }

    public void reset() {
        employee = new EmployeeDTO();
    }

    public void setId(int id) {
        employee.setId(id);
    }

    public void setName(String name) {
        employee.setName(name);
    }

    public void setLastName(String lastName) {
        employee.setLastName(lastName);
    }

    public void setSalary(double salary) {
        employee.setSalary(salary);
    }

    public void setEntryDate(LocalDate entryDate) {
        employee.setEntryDate(entryDate);
    }

    public EmployeeDTO getEmployee() {
        EmployeeDTO product = employee;
        reset();
        return product;
    }

}
