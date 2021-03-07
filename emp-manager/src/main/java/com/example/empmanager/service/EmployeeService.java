package com.example.empmanager.service;

import com.example.empmanager.exceptions.UserNotFoundException;
import com.example.empmanager.model.Employee;
import com.example.empmanager.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepo
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Employee not found by ID %d", id)));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public long count() {
        return employeeRepo.count();
    }
}
