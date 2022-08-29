package com.bridgelabz.employeepayroll.entity;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private  int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",
            joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public Employee(){

    }

    public Employee (EmployeePayrollDTO employeePayrollDto) {
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