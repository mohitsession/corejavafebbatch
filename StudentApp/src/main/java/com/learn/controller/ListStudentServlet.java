package com.learn.controller;

import java.io.IOException;
import java.util.List;

import com.learn.model.Student;
import com.learn.sevice.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/listStudents")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService service = new StudentService();
	
	/**
	 * Default constructor.
	 */
	public ListStudentServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> students = service.getStudents();
		request.setAttribute("students", students);
		request.getRequestDispatcher("/listStudents.jsp").forward(request, response);
		
	}

}
