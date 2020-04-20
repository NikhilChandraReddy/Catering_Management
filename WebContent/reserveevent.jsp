<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>


<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<h1>Request Reservation </h1>  
<form action="/catering_management/EventFormController?action=save_reservation_details" method="post">  
<table>  

<tr>
<td>Last Name:</td>
<td><input type="text" name="lname"  value="${event.getLast_name()}" disabled/></td>

</tr>  

<tr>
<td>First Name:</td>
<td><input type="text" name="fname" value = "${event.getFirst_name()}" disabled/></td>

</tr>  

<tr>
<td>Start Date:</td>
<td><input type="date" name="startdate" value="<c:out value='${event.getStart_date()}' />" disabled ></td>

</tr>  

<tr>
<td>Start Time:</td>
<td><input type="date" name="starttime" value="${event.getStart_time()}" disabled></td>

</tr>  

<tr>
<td>Duration:</td>
<td><select name="duration"> 
	<option>2 Hours</option>  
	<option>3 Hours</option>
	<option>4 Hours</option>
	<option>5 Hours</option>
	<option>6 Hours</option>
	<option>7 Hours</option>
	<option>8 Hours</option>
	</select>
</td>
<td> <input name="durationError" value="<c:out value='${errorMsgs.durationError}' />" class="errorMsg" > </td>
</tr>  

<tr>
<td>Hall Name:</td>
<td><select name="hallname"> 
	<option>Maverick</option>  
	<option>KC</option>
	<option>Arlington</option>
	<option>Shard</option>
	<option>Liberty</option>	
	</select>
</td>
<td> <input name="hall_nameError" value="<c:out value='${errorMsgs.hall_nameError}' />" class="errorMsg" > </td>
</tr>  

<tr>
<td>Est Attendees:</td>
<td><input type="text" name="estattendees" value="${event.getEstimated_attendees()}"></td>
<td> <input name="estimated_attendeesError" value="<c:out value='${errorMsgs.estimated_attendeesError}' />" class="errorMsg" > </td>
</tr>  


<tr>
<td>Event name:</td>
<td><input type="text" name="eventname" value = "${event.getEvent_name()}"></td>
<td> <input name="event_nameError" value="<c:out value='${errorMsgs.event_nameError}' />" class="errorMsg" > </td>
</tr>  


<tr>
<td>Food Type:</td>
<td><select name="foodtype"> 
	<option>American</option>  
	<option>Chinese</option>
	<option>French</option>
	<option>Greek</option>
	<option>Indian</option>
	<option>Italian</option>
	<option>Japanese</option>
	<option>Mexican</option>
	<option>Pizza</option>
	</select>
</td>
</tr>  


<tr>
<td>Meal:</td>
<td><select name="mealtype"> 
	<option>BreakFast</option>  
	<option>Lunch</option>
	<option>Supper</option>
	</select>
</td>
</tr>  


<tr>
<td>Meal Formality:</td>
<td><select name="mealformality"> 
	<option>Formal</option>  
	<option>Informal</option>
	</select>
</td>
</tr>  


<tr>
<td>Drink Type:</td>
<td><select name="drinktype"> 
	<option >Alcohol</option>  
	<option >Non-Alcohol</option>
	</select>
</td>
</tr>  


<tr>
<td>Entertainment Items:</td>
<td><select name="entertainmenttype"> 
	<option>Music</option>  
	<option>Non-Music</option>
	</select>
</td>
</tr>  

<tr><td colspan="2"><input type="submit" value="Reserve"/></td></tr>  
</table>  
</form>  
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>

</html>