package com.learn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListAllStudentsServlet
 */
@WebServlet("/listStudents")
public class ListAllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;

	/**
	 * Default constructor.
	 */
	public ListAllStudentsServlet() {
		// TODO Auto-generated constructor stub
	}

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder output = new StringBuilder();
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from students")) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				output.append(" ID : ").append(resultSet.getString("ID"));
				output.append(" Name : ").append(resultSet.getString("name"));
				output.append(" Email : ").append(resultSet.getString("email"));
				output.append(" Course : ").append(resultSet.getString("course"));
				output.append(" Marks : ").append(resultSet.getString("marks"));
				output.append("<br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
response.setContentType("text/html");
		response.getWriter().append(output);
	}

}
