package com.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learn.model.Student;

public class StudentDAO {

	static final String URL = "jdbc:mysql://localhost:3306/studentdb";
	static final String USER = "root";
	static final String PWD = "admin";

	// INSERT a new student
	public int addStudent(String name, String email, String course, double marks) {

		String sql = "INSERT INTO students (name, email, course, marks) " + "VALUES (?, ?, ?, ?)";
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, name); // replaces 1st ?
			ps.setString(2, email); // replaces 2nd ?
			ps.setString(3, course); // replaces 3rd ?
			ps.setDouble(4, marks); // replaces 4th ?

			rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected + " row(s) inserted.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// try-with-resources auto-closes conn & ps
		return rowsAffected;
	}

	// SELECT all students
	public List<Student> getAllStudents() {

		List<Student> list = new ArrayList();
		String sql = "SELECT * FROM students";

		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setCourse(rs.getString("course"));
				student.setMarks(rs.getDouble("marks"));

				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// UPDATE marks for a given student id
	public void updateMarks(int id, double newMarks) {

		String sql = "UPDATE students SET marks = ? WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setDouble(1, newMarks);
			ps.setInt(2, id);

			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) updated.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DELETE a student by id
	public void deleteStudent(int id) {

		String sql = "DELETE FROM students WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) deleted.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
