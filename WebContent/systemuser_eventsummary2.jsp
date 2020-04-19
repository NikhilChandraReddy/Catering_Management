<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>


<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<h1 align = "center"> View Selected Event</h1>  
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
<td><input type="text" name="Duration" value="${event.getDuration()}" disabled></td>
</tr>  

<tr>
<td>Hall Name:</td>
<td><input type="text" name="starttime" value="${event.getHall_name()}" disabled></td>
</tr>  

<tr>
<td>Est Attendees:</td>
<td><input type="text" name="estattendees" value="${event.getEstimated_attendees()}" disabled></td>
</tr>  


<tr>
<td>Event name:</td>
<td><input type="text" name="eventname" value = "${event.getEvent_name()}" disabled></td>
</tr>  


<tr>
<td>Food Type:</td>
<td><input type="text" name="Food Type" value="${event.getFood_type()}" disabled></td>
</tr>  


<tr>
<td>Meal:</td>
<td><input type="text" name="Meal" value="${event.getMeal()}" disabled></td>
</tr>  


<tr>
<td>Meal Formality:</td>
<td><input type="text" name="Meal Formality" value="${event.getMeal_formality()}" disabled></td>
</tr>  


<tr>
<td>Drink Type:</td>
<td><input type="text" name="Drink Type" value="${event.getDrink_type()}" disabled></td>
</tr>  


<tr>
<td>Entertainment Items:</td>
<td><input type="text" name="Entertainment Items" value="${event.getEntertainment_items()}" disabled></td>
</tr>  

<tr>
<td>Event Status:</td>
<td><input type="text" name="Event Status" value="${event.getEventStatus()}" disabled></td>
</tr>  


</table>  
</form>  
<a href="/catering_management/userhomepage.jsp"><input type="submit" class="button" value="Back"></a>
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>