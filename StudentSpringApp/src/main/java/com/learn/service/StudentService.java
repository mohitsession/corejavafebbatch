package com.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.dao.StudentRepository;
import com.learn.model.Student;

import com.learn.model.Student;
import com.learn.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // ── READ ──────────────────────────────────────────────────

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Student not found: " + id));
    }

    public boolean emailExists(String email) {
        return repo.existsByEmail(email);
    }

    // Returns true if the email is taken by a DIFFERENT student
    public boolean emailTakenByOther(String email, Long currentId) {
        return repo.findByEmail(email)
                   .filter(s -> !s.getId().equals(currentId))
                   .isPresent();
    }

    // ── WRITE ─────────────────────────────────────────────────

    @Transactional
    public void saveStudent(Student student) {
        repo.save(student);
    }

    @Transactional
    public void updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setCourse(updated.getCourse());
        existing.setMarks(updated.getMarks());
        // No save() needed — dirty checking writes UPDATE on commit
    }

    @Transactional
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}

