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
      
 <form action="<c:url value='CatererStaffController?action=listSpecificEvent' />" method="post">         
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTable20">Event Name</th>
				<th class="myTable20">Date</th>
				<th class="myTable35">Start Time</th> 
				<th class="myTable20">Duration</th>
				<th class="myTable30">Hall Name</th> 
        		<th class="myTable30">User Lastname</th>
        		<th class="myTable30">User Firstname</th>
        		

			</tr>

 		<c:forEach items="${eventslist}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableRadio"><input type="radio" id="radioCompany${status.count}" name="radioCompany" value="<c:out value="${status.count}" />"></td> 	
			<td class="myTable20 "><c:out value="${item.event_name}" /></td>
			<td class="myTable35 "><c:out value="${item.date}" /></td>
			<td class="myTable20 "><c:out value="${item.start_time}" /></td>
			<td class="myTable30 "><c:out value="${item.duartion}" /></td>
        	<td class="myTable30 "><c:out value="${item.last_name}" /></td>
        	<td class="myTable30 "><c:out value="${item.first_name}" /></td>
        	 <td> <a href="<c:url value='/CompanyController?action=listSpecificCompany&id=${item.idcompany}' />">View</a></td>
        	

			</tr>
		</c:forEach>
 </table>
<input name="ListSelectedCompanyButton" type="submit" value="View">

</form>
</body>
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>

