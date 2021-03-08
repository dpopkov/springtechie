package com.example.empmanager.bootstrap;

import com.example.empmanager.model.Employee;
import com.example.empmanager.service.EmployeeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private static final String JSON_DATA_PATH = "/json/data.json";

    private final EmployeeService service;

    public DataLoader(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        if (service.count() == 0) {
            loadData();
        }
    }

    private void loadData() {
        var employees = loadFromJson();
        for (Employee emp : employees) {
            service.addEmployee(emp);
        }
        log.info("Loaded {} Employees.", service.count());
    }

    private List<Employee> loadFromJson() {
        ObjectMapper jsonMapper = new ObjectMapper();
        TypeReference<List<Employee>> typeReference = new TypeReference<>() {
        };
        List<Employee> employees = List.of();
        try (InputStream inputStream = TypeReference.class.getResourceAsStream(JSON_DATA_PATH)) {
            employees = jsonMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            log.error("Error reading employees from {}", JSON_DATA_PATH, e);
        }
        return employees;
    }
}
