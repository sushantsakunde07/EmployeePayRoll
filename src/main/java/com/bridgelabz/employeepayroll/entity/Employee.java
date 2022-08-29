package com.bridgelabz.employeepayroll.entity;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
public class Employee {
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;

    public Employee(int employeeId, EmployeePayrollDTO employeePayrollDto) {
        this.employeeId = employeeId;
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDto) {
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.gender = employeePayrollDto.gender;
        this.note = employeePayrollDto.note;
        this.startDate = employeePayrollDto.startDate;
        this.profilePic = employeePayrollDto.profilePic;
        this.department = employeePayrollDto.department;
    }
}