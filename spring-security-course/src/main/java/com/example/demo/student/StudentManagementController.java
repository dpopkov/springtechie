package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    // This dummy copy from StudentController should be removed later
    private static final List<Student> STUDENTS = List.of(
            new Student(1, "Bobby"),
            new Student(2, "Alice"),
            new Student(3, "Timmy")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId")Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("studentId=%s student=%s%n", studentId, student));
    }
}