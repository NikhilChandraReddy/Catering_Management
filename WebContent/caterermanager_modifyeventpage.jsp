<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>


<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<h1 align = "center"> Modify Selected Event</h1>  

<form action = "/catering_management/CatererManagerController?action=modify_event" method = "post">
<table>  

<tr>
<td>Last Name:</td>
<td><input type="text" name="lname" value="<c:out value='${event.getLast_name()}' />"></td>
<td> <input name="last_nameError" value="<c:out value='${errorMsgs.last_nameError}'/>" class="errorMsg"> </td>

</tr>  

<tr>
<td>First Name:</td>
<td><input type="text" name="fname"  value="<c:out value='${event.getFirst_name()}' />"></td>
<td> <input name="first_nameError" value="<c:out value='${errorMsgs.first_nameError}'/>" type="text" class="errorMsg"> </td>	

</tr>  

<tr>
<td>Start Date:</td>
<td><input type="date" name="startdate" value="<c:out value='${event.getStart_date()}' />"  ></td>
<td><input name = "start_dateError" value="<c:out value= '${errorMsgs.start_dateError}' />" class="errorMsg"></td> 

</tr>  

<tr>
<td>Start Time:</td>
<td><input type="date" name="starttime" value="<c:out value='${event.getStart_time()}' />" ></td>
<td><input name = "start_timeError" value="<c:out value= '${errorMsgs.start_timeError}' />" class="errorMsg"></td> 

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
<!--  <td><input type="text" name="hallname"   value="<c:out value='${event.getHall_name()}' />"></td>  -->
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
<td><input type="text" name="estattendees" value="<c:out value='${event.getEstimated_attendees()}' />"></td>
<td> <input name="estimated_attendeesError" value="<c:out value='${errorMsgs.estimated_attendeesError}' />" class="errorMsg" > </td>

</tr>  


<tr>
<td>Event name:</td>
<td><input type="text" name="eventname" value="<c:out value='${event.getEvent_name()}' />"> </td>
<td> <input name="event_nameError" value="<c:out value='${errorMsgs.event_nameError}' />" class="errorMsg" > </td>

</tr>  


<tr>
<td>Food Type:</td>
<!--   <td><input type="text" name="foodtype" value="<c:out value='${event.getFood_type()}' />"> </td>  -->
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
<!--   <td><input type="text" name="mealtype" value="<c:out value='${event.getMeal()}' />"> </td>   -->
<td><select name="mealtype"> 
	<option>BreakFast</option>  
	<option>Lunch</option>
	<option>Supper</option>
	</select>
</td>
</tr>  


<tr>
<td>Meal Formality:</td>
<!--   <td><input type="text" name="mealformality"  value="<c:out value='${event.getMeal()}' />"></td>  -->
<td><select name="mealformality"> 
	<option>Formal</option>  
	<option>Informal</option>
	</select>
</td>

</tr>  


<tr>
<td>Drink Type:</td>
<!--  <td><input type="text" name="drinktype" value="<c:out value='${event.getDrink_type()}' />"> </td> -->
<td><select name="drinktype"> 
	<option >Alcohol</option>  
	<option >Non-Alcohol</option>
	</select>
</td>
</tr>  


<tr>
<td>Entertainment Items:</td>
<!--   <td><input type="text" name="entertainmenttype" value="<c:out value='${event.getEntertainment_items()}' />"> </td> -->
<td><select name="entertainmenttype"> 
	<option>Music</option>  
	<option>Non-Music</option>
	</select>
</td>
</tr>  

<tr>
<td>Event Status:</td>
<td><input type="text" name="eventstatus" value="<c:out value='${event.getEventStatus()}' />"> </td>
</tr>  

<tr>
<td>Assigned Staff Last Name:</td>
<td><input type="text" name="Assigned_lname" value="<c:out value='${event.getAssigned_lname()}' />"> </td>
<td> <input name="assignedlast_nameError" value="<c:out value='${errorMsgs.getAssignedLast_nameError()}'/>" class="errorMsg"> </td>
</tr>  

<tr>
<td>Assigned Staff First Name:</td>
<td><input type="text" name="Assigned_fname" value="<c:out value='${event.getAssigned_fname()}' />"> </td>
<td> <input name="assignedfirst_nameError" value="<c:out value='${errorMsgs.getAssignedFirst_nameError()}'/>" class="errorMsg"> </td>
</tr>  

<tr><td colspan="2"><input type="submit" value="Modify"  onclick="if (confirm('Are you sure you want to modify?')) form.action='/catering_management/CatererManagerController?action=modify_event'; else  form.action='/catering_management/CatererManagerController?action=cancel';"    /></td></tr>  
</table>  
</form>  

<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>