package com.alammar.jdbc.example;

import com.alammar.jdbc.example.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcExampleApplication implements CommandLineRunner {

    @Autowired
    private EmployeesService employeesService;

    public static void main(String[] args) {
        SpringApplication.run(JdbcExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            employeesService.saveEmployeesWithoutTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeesService.printEmployees();
        employeesService.deleteAllEmployees();

        try {
            employeesService.saveEmployeesInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeesService.printEmployees();
        employeesService.deleteAllEmployees();
    }

}
