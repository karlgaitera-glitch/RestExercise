package com.example.spring.spring_rest.controller;

import com.example.spring.spring_rest.entity.StudentOld;
import com.example.spring.spring_rest.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<StudentOld> theStudents;

    @PostConstruct
    public void initialize() {
        theStudents = new ArrayList<>();

        theStudents.add(new StudentOld("First", "Student1"));
        theStudents.add(new StudentOld("Second", "Student2"));
        theStudents.add(new StudentOld("Third", "Student3"));
    }

    @GetMapping("/students")
    public List<StudentOld> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public StudentOld getStudent(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || (studentId < 0)) {
            throw new StudentNotFoundException(
                    "Student id " + studentId + "not found!");
        }
        return theStudents.get(studentId);
    }
}
