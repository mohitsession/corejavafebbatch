<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springframework.validation.BindingResult,
                  org.springframework.validation.FieldError" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <style>
        body  { font-family: Arial; background: #FFF8E1;
                display: flex; justify-content: center; padding-top: 50px; }
        .card { background: #fff; padding: 36px; border-radius: 8px;
                box-shadow: 0 2px 12px rgba(0,0,0,.12); width: 420px; }
        h2    { color: #4E342E; margin-bottom: 20px; }
        label { font-size: 13px; color: #555;
                display: block; margin-bottom: 4px; }
        input, select { width: 100%; padding: 9px; border: 1px solid #ccc;
                        border-radius: 4px; margin-bottom: 4px;
                        font-size: 14px; box-sizing: border-box; }
        .err  { color: #B71C1C; font-size: 12px;
                display: block; margin-bottom: 10px; }
        .row  { display: flex; gap: 10px; margin-top: 10px; }
        .btn  { flex: 1; padding: 10px; border: none; border-radius: 4px;
                font-size: 14px; cursor: pointer; }
        .save { background: #6D4C41; color: #fff; }
        .back { background: #EEE; color: #333; text-decoration: none;
                text-align: center; line-height: 2.7; }
    </style>
</head>
<body>
<div class="card">
    <h2>Add New Student</h2>

    <form action="<%= request.getContextPath() %>/students/add"
          method="post">

        <label>Name</label>
        <input type="text" name="name"
               value="<%= request.getParameter("name") != null
                          ? request.getParameter("name") : "" %>">
        <%
            BindingResult br =
                (BindingResult) request.getAttribute(
                    "org.springframework.validation.BindingResult.student");
            if (br != null && br.hasFieldErrors("name")) {
                for (FieldError e : br.getFieldErrors("name")) { %>
                    <span class="err"><%= e.getDefaultMessage() %></span>
        <%      }
            }
        %>

        <label>Email</label>
        <input type="email" name="email"
               value="<%= request.getParameter("email") != null
                          ? request.getParameter("email") : "" %>">
        <%
            if (br != null && br.hasFieldErrors("email")) {
                for (FieldError e : br.getFieldErrors("email")) { %>
                    <span class="err"><%= e.getDefaultMessage() %></span>
        <%      }
            }
        %>

        <label>Course</label>
        <select name="course">
            <option value="">-- Select --</option>
            <option value="Java">Java</option>
            <option value="Python">Python</option>
            <option value="DBMS">DBMS</option>
            <option value="Spring">Spring</option>
        </select>
        <%
            if (br != null && br.hasFieldErrors("course")) {
                for (FieldError e : br.getFieldErrors("course")) { %>
                    <span class="err"><%= e.getDefaultMessage() %></span>
        <%      }
            }
        %>

        <label>Marks (0 - 100)</label>
        <input type="number" name="marks" step="0.1" min="0" max="100"
               value="<%= request.getParameter("marks") != null
                          ? request.getParameter("marks") : "" %>">
        <%
            if (br != null && br.hasFieldErrors("marks")) {
                for (FieldError e : br.getFieldErrors("marks")) { %>
                    <span class="err"><%= e.getDefaultMessage() %></span>
        <%      }
            }
        %>

        <div class="row">
            <button type="submit" class="btn save">Save</button>
            <a class="btn back"
               href="<%= request.getContextPath() %>/students">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
