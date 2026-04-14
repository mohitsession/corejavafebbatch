package com.learn.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Hardcoded credentials for demo — in real apps use a DB users table
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin123";

    // GET /login → show the login page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
                         throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    // POST /login → process login form
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
                          throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {

            // ✅ Valid login — create session
            HttpSession session = req.getSession();        // creates new session
            session.setAttribute("username", username);   // store user info
            session.setMaxInactiveInterval(30 * 60);       // expire after 30 min

            res.sendRedirect(req.getContextPath() + "/listStudents");

        } else {

            // ❌ Invalid login — show error on JSP
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }
}

