package com.bridgelabz.employeepayroll.entity;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;


public class Employee {
    private int employeeId;
    private String name;
    private long salary;

    public Employee() {
    }

    public Employee(int empId, EmployeePayrollDTO empPayrollDTO) {
        this.employeeId = empId;
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}