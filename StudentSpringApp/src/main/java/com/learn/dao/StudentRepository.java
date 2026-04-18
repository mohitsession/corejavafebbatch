package com.learn.dao;

import com.learn.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // Check if an email is already taken
    // Spring generates: SELECT 1 FROM students WHERE email = ?
    boolean existsByEmail(String email);

    // Used during edit to check if email belongs to a different student
    // Spring generates: SELECT * FROM students WHERE email = ?
    Optional<Student> findByEmail(String email);
}


