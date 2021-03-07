package com.example.empmanager.bootstrap;

import com.example.empmanager.model.Employee;
import com.example.empmanager.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeService service;

    public DataLoader(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        if (service.count() == 0) {
            loadEmployees();
        }
    }

    private void loadEmployees() {
        Employee e1 = Employee.builder().name("Bobby").phone("123-4567").jobTitle("Tester").build();
        Employee e2 = Employee.builder().name("Alice").phone("456-4567").jobTitle("Dev").build();
        service.addEmployee(e1);
        service.addEmployee(e2);
        log.info("Loaded {} Employees.", service.count());
    }
}
