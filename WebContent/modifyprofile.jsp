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
<h3 align = "left">Modify Profile</h3>
<form action="/catering_management/UserController" method="post">
<input name="usernameError" value="<c:out value='${errorMsgs.errorMsg}' />" class="errorMsg" ><br>
<table style="width: 100%">
			<tr>
				<td>UserName (*):</td>
				<td><input name="username"  value="<c:out value='${vuser.getUsername()}'/>" class="text16"></td>
 				<td> <input name="usernameError" value="<c:out value='${errorMsgs.usernameError}' />" class="errorMsg" > </td>
 				
			</tr>
			<tr>
				<td>Password (*):</td>
				<td><input type="password" name="password"  value="<c:out value='${vuser.getPassword()}'/>" class="text16"></td>
 				<td> <input name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>" type="text" class="errorMsg"> </td>
			</tr>
			<tr>
				<td>Last Name (*):</td>
				<td><input name="last_name"  value="<c:out value='${vuser.getLastName()}'/>" class="text16"></td>
 				<td> <input name="last_nameError" value="<c:out value='${errorMsgs.last_nameError}'/>" class="errorMsg"> </td>
			</tr>
			<tr>
				<td>First Name (*):</td>
				<td><input type="text" name="first_name" value="<c:out value='${vuser.getFirstName()}'/>" class="text16" ></td>
 				<td> <input name="first_nameError" value="<c:out value='${errorMsgs.first_nameError}'/>" type="text" class="errorMsg"> </td>	
 			</tr>
			<tr>
				<td>Role (*):</td>
				<td><input type="text" name="role" disabled value="<c:out value='${vuser.getRole()}'/>" class="text16" /></td>
				<td> <input name="RoleERR" value="<c:out value='${RoleERR}'/>" type="text" class="errorMsg"> </td>	
				
			</tr> 			
			<tr>
				<td>UTA ID (*):</td>
				<td><input type="text" name="uta_id"  value="<c:out value='${vuser.getUtaId()}'/>" class="text16" /></td>
				<td> <input name="utaIDError" value="<c:out value='${errorMsgs.utaIDError}'/>" type="text" class="errorMsg"> </td>
			</tr>
			<tr>
				<td>Phone (*) :</td>
				<td><input type="text" name="phone" value="<c:out value='${vuser.getPhone()}'/>" class="text16" /></td>
 				<td> <input name="phoneError" value="<c:out value='${errorMsgs.phoneError}'/>" type="text" class="errorMsg"> </td>
			</tr>			
			<tr>
				<td>Email (*):</td>
				<td><input type="text" name="email" value="<c:out value='${vuser.getEmail()}'/>" class="text16" /></td>
 				<td> <input name="emailError" value="<c:out value='${errorMsgs.emailError}'/>" type="text" class="errorMsg"> </td>
			</tr>
			<tr>
				<td> Street Number (*):</td>
				<td><input type="text" name="street_number" value="<c:out value='${vuser.getStreet_Number()}'/>" class="text16" /></td>
 				<td> <input name="street_numberError" value="<c:out value='${errorMsgs.street_numberError}'/>" class="errorMsg"> </td>
			</tr>
			<tr>
				<td> Street Name (*):</td>
				<td><input type="text" name="street_name" value="<c:out value='${vuser.getStreet_Name()}'/>" class="text16" /></td>
 				<td> <input name="street_nameError" value="<c:out value='${errorMsgs.street_nameError}'/>" class="errorMsg"> </td>
			</tr>		
			<tr>
				<td> City (*):</td>
				<td><input type="text" name="city" value="<c:out value='${vuser.getCity()}'/>" class="text16" /></td>
 				<td> <input name="cityError" value="<c:out value='${errorMsgs.cityError}'/>" class="errorMsg"> </td>
			</tr>	

			<tr>
				<td> State (*):</td>
				<td><input type="text" name="state" value="<c:out value='${vuser.getState()}'/>" class="text16"/></td>
 				<td> <input name="stateError" value="<c:out value='${errorMsgs.stateError}'/>" class="errorMsg"> </td>
			</tr>
			<tr>
				<td> Zip Code (*):</td>
				<td><input type="text" name="zip_code" value="<c:out value='${vuser.getZipCode()}'/>" class="text16" /></td>
 				<td> <input name="zipcodeError" value="<c:out value='${errorMsgs.zipcodeError}'/>" type="text" class="errorMsg"> </td>
			</tr>

			
</table>

  
  <input type="submit" value="Update"  onclick="if (confirm('Are you sure you want to modify?')) form.action='/catering_management/UserController?action=save_details'; else  form.action='/catering_management/UserController?action=cancel';"    /></td></tr>  

</body>
</html>