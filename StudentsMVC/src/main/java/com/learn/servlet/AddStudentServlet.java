package com.learn.servlet;

import java.io.IOException;

import com.learn.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
                    throws ServletException, IOException {

        // 1. Read form parameters
        String name   = req.getParameter("name");
        String email  = req.getParameter("email");
        String course = req.getParameter("course");
        double marks  = Double.parseDouble(req.getParameter("marks"));

        // 2. Call DAO to save to DB
        StudentDAO dao = new StudentDAO();
        int success = dao.addStudent(name, email, course, marks);

        // 3. Redirect based on result
        if (success > 0) {
            res.sendRedirect("listStudents");
        } else {
            res.sendRedirect("index.html?error=1");
        }
    }
}

