<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
	<link href="style.css" rel="stylesheet" type="text/css"/>
<body>
<h1 align = "left">Catering Management</h1>
<h3 align = "left">Login</h3>
<form action="/catering_management/LoginController" method="post">
<input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'></c:out>" type="text" class="errorPane" style="width: 200%">

<table style="width: 50%">
			<tr>
				<td align = "center">UserName</td>
				<td align = "center"><input name="username" value="<c:out value='${login.getUsername()}'/>" class="text45"></td>
 				<td><input name="usernameError" value="<c:out value='${errorMsgs.usernameError}'/>" type="text" class="errorMsg"> </td>
			</tr>
			<tr>
				<td align = "center">Password</td>
				<td align = "center"><input type="password" name="password"  class="text45"></td>
 				<td><input name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>" type="text" class="errorMsg"> </td>
			</tr>
</table>


<input name="action"type="submit" value="login" />
</form>
			<a href = "/catering_management/registration.jsp" >Register as a new user</a>

</body>
</html>