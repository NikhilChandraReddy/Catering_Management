<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Screen</title>
</head>
<body>
<h1 align = "left">Catering Management</h1>
<h3 align = "left">User Homepage</h3>

<table>
<tr><td>
<a href = "/catering_management/DateController?action=datepage">Reserve Event</a>
</td></tr>
<tr><td><a href = "/catering_management/DateController?action=systemuserdatepage">View My Events Summary</a></td></tr>
<tr><td><a href = "/catering_management/UserController?action=ViewProfile">View Profile</a></td></tr>
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</table>
<!-- </form> -->
</body>
</html>