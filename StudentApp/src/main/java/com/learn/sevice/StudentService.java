package com.learn.sevice;

import java.sql.SQLException;
import java.util.List;

import com.learn.dao.StudentDAO;
import com.learn.model.Student;

public class StudentService {

	private StudentDAO studentDAO;

	public StudentService() {
		this.studentDAO = new StudentDAO();
	}

	public String addStudent(Student student) {
		String error = null;
		try {
			int affectedRows = studentDAO.addStudent(student);
			if (affectedRows == 0) {
				error = "Error in inserting student object ";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			error = "Email is null";
		}
		return error;
	}

	public List<Student> getStudents() {
		return studentDAO.getStudents();
		
	}

}
