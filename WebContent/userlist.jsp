<!-- userSearchResults.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Users List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
	<div class="logo">
		<h1>
			<a href="/Mac_Facility">Catering Management</a>
		</h1>
	</div>

	<!-- change -->
	<form action="/catering_management/AdminController" method="post">
		<table border="1" class="myTable">
			<tr class="myTableRow">
				<th class="myTableHead"
					style="padding-right: 20px; text-align: left">Select User</th>
				<th class="myTableHead"
					style="padding-right: 20px; text-align: left">Last Name</th>
				<th class="myTableHead"
					style="padding-right: 20px; text-align: left">First Name</th>
				<th class="myTableHead"
					style="padding-right: 20px; text-align: left">Username</th>
				<th class="myTableHead"
					style="padding-right: 30px; text-align: left">Role</th>
			</tr>

			<c:forEach items="${USERS}" var="item" varStatus="status">
				<tr class="myTableRow">
				<td class="myTableRadio"><input type="radio" id="radiouser${status.count}" name="radiouser" value="<c:out value="${status.count}" />"></td> 	
				
					<td class="myTableCell" style="padding-right: 20px;"><c:out
							value="${item.getLastName()}" /></td>
					<td class="myTableCell" style="padding-right: 20px;"><c:out
							value="${item.getFirstName()}" /></td>
					<td class="myTableCell" style="padding-right: 20px;"><c:out
							value="${item.getUsername()}" /></td>
					<td class="myTableCell" style="padding-right: 30px;"><c:out
							value="${item.getRole()}" /></td>
				</tr>
			</c:forEach>
			
		</table>
		
		<br><br><br>
			<tr>
			<input name="action"  type="submit" value="modify selected user">
			<!--  <input name="action"  type="submit" value="delete selected user" '>-->
			<input name="action" type="submit" value="delete selected user" onclick="if (confirm('Are you sure you want to delete?')) form.action='/catering_management/AdminController?action=delete selected user'; else return false;" />


			
			</tr>
	</form>
</body>
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>