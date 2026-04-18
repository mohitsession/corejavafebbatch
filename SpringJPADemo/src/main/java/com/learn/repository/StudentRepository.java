package com.learn.repository;

import com.learn.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//select * from student where name = ?
	public Student findByName(String name);
}
