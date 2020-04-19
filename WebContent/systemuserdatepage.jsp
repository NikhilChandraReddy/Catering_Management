<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<!DOCTYPE html>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catering Management</title>
</head>
<body>
<h1 align = "center">Catering Management</h1>

  <form action="/catering_management/UserController?action=save_date" method = "post">
<table>

<tr>
<td>Start Date:</td>
<td><input type="date" name="startdate" value ='${date}'	></td>
<td><input name = "start_dateError" value="<c:out value= '${errorMsgs.getStart_dateError()}' />" class="errorMsg"></td> 

</tr>  

<tr>
<td>Start Time:</td>
<td><input type="time" name="starttime" value="<c:out value ='${time}'/>" /></td>
<td><input name = "start_timeError" value="<c:out value= '${errorMsgs.getStart_timeError()}' />" class="errorMsg"></td> 

  </tr> 
    
    </table>
      <input type="submit" >

  </form>
</body>
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>