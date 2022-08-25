package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.entity.Employee;
import java.util.List;

public interface EmployeePayrollService {
    List<Employee> getEmployeeDetails();

    Employee getEmployeeDetailsById(int empId);

    Employee CreateEmployeeDetails(EmployeePayrollDTO employeePayrollDto);

    Employee updateEmployeeDetails(int empId, EmployeePayrollDTO employeePayrollDto);

    void deleteEmployeeDetails(int empId);
}