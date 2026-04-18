<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.learn.model.Student, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students</title>
    <style>
        body { font-family: Arial; background: #FFF8E1; padding: 30px; }
        h2   { color: #4E342E; }
        a.btn { background: #6D4C41; color: #fff; padding: 9px 18px;
                text-decoration: none; border-radius: 4px; font-size: 13px; }
        table { width: 100%; border-collapse: collapse; background: #fff;
                margin-top: 20px; border-radius: 6px; overflow: hidden;
                box-shadow: 0 2px 8px rgba(0,0,0,.1); }
        th { background: #6D4C41; color: #fff; padding: 12px;
             text-align: left; font-size: 13px; }
        td { padding: 10px 12px; border-bottom: 1px solid #EEE; font-size: 13px; }
        tr:hover { background: #FFF8E1; }
        .del { background: #B71C1C; color: #fff; border: none;
               padding: 6px 12px; border-radius: 4px;
               cursor: pointer; font-size: 12px; }
        .edit { background: #6D4C41; color: #fff; padding: 6px 12px;
                text-decoration: none; border-radius: 4px; font-size: 12px; }
    </style>
</head>
<body>
    <h2>Student Records</h2>
    <a class="btn"
       href="<%= request.getContextPath() %>/students/add">+ Add Student</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Course</th>
                <th>Marks</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Student> students =
                (List<Student>) request.getAttribute("students");

            if (students == null || students.isEmpty()) {
        %>
            <tr>
                <td colspan="6"
                    style="text-align:center;color:#999;padding:24px">
                    No students yet.
                </td>
            </tr>
        <%
            } else {
                for (Student s : students) {
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCourse() %></td>
                <td><%= s.getMarks() %></td>
                <td style="display:flex; gap:8px">
                    <a class="edit"
                       href="<%= request.getContextPath()%>/students/<%= s.getId() %>/edit">Edit</a>

                    <%-- Use POST for delete to avoid accidental deletion --%>
                    <form
                      action="<%= request.getContextPath() %>/students/<%= s.getId() %>/delete"
                      method="post"
                      onsubmit="return confirm('Delete <%= s.getName() %>?')">
                        <button class="del">Delete</button>
                    </form>
                </td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</body>
</html>
