package com.bridgelabz.employeepayroll;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayRollApplication {

    public static void main(String[] args) {
        System.out.println("Hello World");
        ApplicationContext context = SpringApplication.run(EmployeePayRollApplication.class, args);
        log.info("Employee Payroll Strated in {} Environment", context.getEnvironment().getProperty("environment"));
        log.info("Employee Payroll DB User is {}", context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
