<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
  <div class="logo">
    <h1>
      <a href="catering_management">Catering Management </a>
    </h1>
  </div>
  <div class="menu_nav"></div>
  <input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>"
    type="text"
    disabled="disabled"class="errorPane" >

        <form action="/catering_management/CatererManagerController?action=searchforstaffs"
          method="post">
<table >
        	<tr>
        		<td><input name="lastNameError" value="<c:out value='${mainerror}'/>" type="text" style="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
        		</tr>
			<tr>
				<td >Staff Last name:  
				<input text="text" name="last_name" value="<c:out value='${user.getLastName()}'/>" /></td>
			</tr>
			<tr>
				<td >Staff First name:
				<input type="text" name="first_name"  value="<c:out value='${user.getFirstName()}'/>"/>
			</tr>
</table>
          <input type="submit" id="submit" value="Submit">
        </form>
        
        
        
        <tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>

</body>
</html>