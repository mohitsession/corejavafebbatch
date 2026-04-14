<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <h2>Register New Student</h2>

        <% String err = request.getParameter("error");
           if ("duplicate".equals(err)) { %>
            <div class="error">Email already exists. Please use a different email.</div>
        <% } %>

        <form action="${pageContext.request.contextPath}/addStudent" method="POST">
            <label>Full Name</label>
            <input type="text"   name="name"   required placeholder="e.g. Alice Johnson">

            <label>Email</label>
            <input type="email"  name="email"  required placeholder="alice@example.com">

            <label>Course</label>
            <select name="course">
                <option>Java</option>
                <option>Python</option>
                <option>DBMS</option>
                <option>Web Development</option>
            </select>

            <label>Marks (0-100)</label>
            <input type="number" name="marks" min="0" max="100" step="0.1" required>

            <div class="actions">
                <button type="submit" class="btn btn-primary">Save Student</button>
                <a href="${pageContext.request.contextPath}/listStudents"
                   class="btn btn-secondary">Cancel</a>
            </div>
        </form>

</body>
</html>