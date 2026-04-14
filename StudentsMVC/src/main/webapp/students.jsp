<%@page import="com.learn.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Student Records</h2>

    <%-- Read session attribute set by Servlet --%>
    <% String loggedInUser = (String) session.getAttribute("username"); %>

    <div class="toolbar">
        <span class="welcome">Welcome, <strong><%= loggedInUser %></strong></span>
        <div>
            <a class="btn" href="${pageContext.request.contextPath}/addStudent.jsp">
               + Add Student</a>
            <a class="btn btn-red"
               href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>
    </div>

    <table>
        <thead>
            <tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Marks</th><th>Action</th></tr>
        </thead>
        <tbody>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students == null || students.isEmpty()) {
        %>
            <tr><td colspan="6" style="text-align:center;color:#999;">
                No students found. Add one!</td></tr>
        <% } else {
               for (Student s : students) { %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCourse() %></td>
                <td><%= s.getMarks() %></td>
                <td>
                    <a href="deleteStudent?id=<%= s.getId() %>"
                       style="color:red;">Delete</a>
                </td>
            </tr>
        <% } } %>
        </tbody>
    </table>

</body>
</html>