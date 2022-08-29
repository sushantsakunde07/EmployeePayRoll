package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.entity.Employee;
import com.bridgelabz.employeepayroll.exception.EmployeePayrollException;
import com.bridgelabz.employeepayroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements EmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> getEmployeeDetails() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeDetailsById(int empId) {
        return employeeList.stream()
                .filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public Employee CreateEmployeeDetails(EmployeePayrollDTO employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(employeePayrollDto);
        employeeList.add(employee);
        log.debug("Employee Data: " + employee.toString());
        return employeePayrollRepository.save(employee);
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