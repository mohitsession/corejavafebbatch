package com.learn.servlet;

import java.io.IOException;
import java.util.List;

import com.learn.dao.StudentDAO;
import com.learn.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listStudents")
public class ListStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
                         throws ServletException, IOException {

        // ── CONTROLLER RESPONSIBILITIES ──────────────────

        // 1. Call the MODEL
        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudents();

        // 2. Pass data to the VIEW via request attribute
        req.setAttribute("students", students);

        // 3. Forward to VIEW (JSP)
        //    Note: Servlet does NOT write any HTML
        req.getRequestDispatcher("students.jsp")
           .forward(req, res);
    }
}

