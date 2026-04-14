package com.learn.servlet;

import java.io.IOException;

import com.learn.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
                   throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        StudentDAO dao = new StudentDAO();
        dao.deleteStudent(id);
        res.sendRedirect("listStudents");
    }
}

