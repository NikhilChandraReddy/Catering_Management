<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify User</title>
</head>
<body>
<h1 align = "left">Catering Management</h1>
<h3 align = "left">Modify User</h3>
<form action="/catering_management/AdminController?action=changerole" method="post">
<td> <input name="RoleERR" value="<c:out value='${confirm}'/>" type="text" class="errorMsg"> </td>	

<table style="width: 100%">
			<tr>
				<td>UserName (*):</td>
				<td><input name="username" disabled value="<c:out value='${muser.getUsername()}'/>" class="text16"></td>
 				
			</tr>
			<tr>
				<td>Last Name (*):</td>
				<td><input name="last_name" disabled value="<c:out value='${muser.getLastName()}'/>" class="text16"></td>
			</tr>
			<tr>
				<td>First Name (*):</td>
				<td><input type="text" name="first_name" disabled value="<c:out value='${muser.getFirstName()}'/>" class="text16" ></td>
 			</tr>
			<tr>
				<td>Role (*):</td>
				<td>
					<select name = "role" >
						<option value = "User">User</option>
						<option value = "Caterer_Staff">Caterer staff</option>
						<option value = "Caterer_Manager">Caterer Manager</option>
						<option value = "Admin">Admin</option>

					</select>
				</td>
				<td> <input name="RoleERR" value="<c:out value='${RoleERR}'/>" type="text" class="errorMsg"> </td>	
				
			</tr> 			
			<tr>
				<td>UTA ID (*):</td>
				<td><input type="text" name="uta_id" disabled value="<c:out value='${muser.getUtaId()}'/>" class="text16" /></td>
			</tr>
			<tr>
				<td>Phone (*) :</td>
				<td><input type="text" name="phone" disabled value="<c:out value='${muser.getPhone()}'/>" class="text16" /></td>
			</tr>			
			<tr>
				<td>Email (*):</td>
				<td><input type="text" name="email" disabled value="<c:out value='${muser.getEmail()}'/>" class="text16" /></td>
			</tr>
			<tr>
				<td> Street Number (*):</td>
				<td><input type="text" name="street_number" disabled value="<c:out value='${muser.getStreet_Number()}'/>" class="text16" /></td>
			</tr>
			<tr>
				<td> Street Name (*):</td>
				<td><input type="text" name="street_name" disabled value="<c:out value='${muser.getStreet_Name()}'/>" class="text16" /></td>
			</tr>		
			<tr>
				<td> City (*):</td>
				<td><input type="text" name="city" disabled value="<c:out value='${muser.getCity()}'/>" class="text16" /></td>
			</tr>	

			<tr>
				<td> State (*):</td>
				<td><input type="text" name="state" disabled value="<c:out value='${muser.getState()}'/>" class="text16"/></td>
			</tr>
			<tr>
				<td> Zip Code (*):</td>
				<td><input type="text" name="zip_code" disabled value="<c:out value='${muser.getZipCode()}'/>" class="text16" /></td>
 			</tr>

			
</table>
<input name="action" value="changerole" type="hidden">
  <input type="submit" value="Submit" /></form>

</body>
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>