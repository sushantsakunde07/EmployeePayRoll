package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService{

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> getEmployeeDetails() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeDetailsById(int empId) {
        return employeeList.get(empId - 1);
    }

    @Override
    public Employee CreateEmployeeDetails(EmployeePayrollDTO employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(employeeList.size() + 1, employeePayrollDto);
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployeeDetails(int empId, EmployeePayrollDTO employeePayrollDto) {
        Employee empDetails = this.getEmployeeDetailsById(empId);
        empDetails.setName(employeePayrollDto.name);
        empDetails.setSalary(employeePayrollDto.salary);
        employeeList.set(empId - 1, empDetails);
        return empDetails;
    }

    @Override
    public void deleteEmployeeDetails(int empId) {
        Employee empDetails = this.getEmployeeDetailsById(empId);
        employeeList.remove(empDetails);
    }
}