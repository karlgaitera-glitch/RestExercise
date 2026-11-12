package com.example.spring.spring_rest.service;

import com.example.spring.spring_rest.mapper.StudentMapper;
import com.example.spring.spring_rest.repository.StudentRepository;
import com.example.spring.spring_rest.entity.Student;
import com.example.spring.spring_rest.dto.StudentDto;

import org.springframework.stereotype.Service;

@Service 
public class StudentServiceImplement implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImplement(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }    

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override 
    public StudentDto createStudent(StudentDto theStudentDto) {
        Student theStudent = StudentMapper.mapToStudent(theStudentDto);
        Student saved = studentRepository.save(theStudent);
        return StudentMapper.mapToStudentDto(saved);
    }
}
