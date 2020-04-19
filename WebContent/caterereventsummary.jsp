<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Caterer Events Summary List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href="myStyle.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1 align = "center"><a href="<c:url value='/' />">Caterer Event Summary Page</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

<input name="errMsg"  value="<c:out value='${errorMsgs}'/>" class="errorPane">
     <div class="mainbar"><div class="submb"></div></div>
      
 <form action="/catering_management/CatererManagerController"  method="post">         
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
			<th class="myTableHead"
					style="padding-right: 20px; text-align: left">Select User</th>
				<th class="myTable20">Event Name</th>
				<th class="myTable20">Date</th>
				<th class="myTable35">Start Time</th> 
				<th class="myTable20">Duration</th>
				<th class="myTable30">Hall Name</th> 
        		<th class="myTable30">User Lastname</th>
        		<th class="myTable30">User Firstname</th>
        		<th class="myTable30">Estimated Attendees</th>

			</tr>

 		<c:forEach items="${eventslist}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableRadio"><input type="radio" id="radioevent${status.count}" name="radioevent" value="<c:out value="${status.count}" />"></td> 	
			<td class="myTable20 "><c:out value="${item.getEvent_name()}" /></td>
			<td class="myTable35 "><c:out value="${item.getStart_date()}" /></td>
			<td class="myTable20 "><c:out value="${item.getStart_time()}" /></td>
			<td class="myTable30 "><c:out value="${item.getDuration()}" /></td>
			<td class="myTable30 "><c:out value="${item.getHall_name()}" /></td>
        	<td class="myTable30 "><c:out value="${item.getLast_name()}" /></td>
        	<td class="myTable30 "><c:out value="${item.getFirst_name()}" /></td>
        	<td class="myTable30 "><c:out value="${item.getEstimated_attendees()}" /></td>

			</tr>
		</c:forEach>
 </table>
<input name="action" type="submit" value="View Selected Event">
<input name="action" type="submit" value="Modify Selected Event">
<input  name="action" type="submit" value="Assign Staff"></a>

	</form>
	
	<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</body>
</html>

