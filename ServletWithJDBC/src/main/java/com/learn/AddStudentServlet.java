package com.learn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Get connection from driverManager
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "admin");
			
			System.out.println("Connection created successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Default constructor.
	 */
	public AddStudentServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		int rowAffected = addStudent(name, email, course, marks);
		
		String message;
		
		if(rowAffected>0) {
			message = "Data inserted";
		} else {
			message = "Failure";
		}
		response.getWriter().append(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		try {
			connection.close();
			System.out.println("connection is closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int addStudent(String name, String email, String course, double marks) {
		int executeUpdate =0;
		try (
			PreparedStatement preparedStatement = connection
						.prepareStatement("insert into students (name, email,course,marks) values (?, ?, ?, ?)")) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, course);
			preparedStatement.setDouble(4, marks);
			executeUpdate = preparedStatement.executeUpdate();
			System.out.println("rows affected : " + executeUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return executeUpdate;
	}
}
