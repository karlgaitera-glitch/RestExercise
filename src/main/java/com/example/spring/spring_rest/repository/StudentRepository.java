package com.example.spring.spring_rest.repository;

import com.example.spring.spring_rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for {@link Student} entities.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
