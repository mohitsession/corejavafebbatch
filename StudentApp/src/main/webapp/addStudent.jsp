<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
</head>
<body>
<%
	String error = (String) request.getAttribute("error");
	if(error != null){
		out.print(error);
	}
%>

	<form action="addStudent" method="post">
		Name : <input type="text" name="name"> <br> 
		Email : <input
			type="text" name="email"> <br> 
			Course: <input
			type="text" name="course"> <br> 
			Marks : <input
			type="number" name="marks"> <br> <input type="submit">
	</form>
</body>
</html>