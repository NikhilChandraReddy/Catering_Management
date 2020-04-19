<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>


<html>

<h1 align = "center">Event Summary</h1>  
<form action="/catering_management/EventFormController?action=save_event_summary_details" method="post">  
<table>  

<tr>
<td>Last Name:</td>
<td><input type="text" name="lname"  value="${event.getLast_name()}" disabled /></td>

</tr>  

<tr>
<td>First Name:</td>
<td><input type="text" name="fname" value = "${event.getFirst_name()}" disabled /></td>

</tr>  

<tr>
<td>Start Date:</td>
<td><input type="date" name="startdate" value="${event.getStart_date()}" disabled ></td>

</tr>  

<tr>
<td>Start Time:</td>
<td><input type="date" name="starttime" value="${event.getStart_time()}" disabled ></td>

</tr>  

<tr>
<td>Duration:</td>
<td><input type="text"  name="duration" value="${event.getDuration()}" disabled / > 

</td>
</tr>  

<tr>
<td>Hall Name:</td>
<td><input type="text" name="hallname" value="${event.getHall_name()}" disabled /> 
</td>
</tr>  

<tr>
<td>Est Attendees:</td>
<td><input type="text" name="estattendees" value="${event.getEstimated_attendees()}" disabled ></td>
</tr>  


<tr>
<td>Event name:</td>
<td><input type="text" name="eventname" value="${event.getEvent_name()}" disabled ></td>
</tr>  


<tr>
<td>Food Type:</td>
<td><input type="text" name="foodtype" value="${event.getFood_type()}" disabled /> 

</td>
</tr>  


<tr>
<td>Meal:</td>
<td><input type="text" name="mealtype" value="${event.getMeal()}" disabled /> 
 </td>
</tr>  


<tr>
<td>Meal Formality:</td>
<td><input type = "text" name="mealformality" value = "${event.getMeal_formality()}" disabled > 
    
</td>
</tr>  


<tr>
<td>Drink Type:</td>
<td><input type="text" name = "drinktype" value = "${event.getDrink_type()}" disabled /> 
    
</td>
</tr>  


<tr>
<td>Entertainment Items:</td>
<td><input type="text" name="entertainmenttype" value = "${event.getEntertainment_items()}" disabled /> 
  
</td>
</tr>  
<tr>
<td>
<input type = "submit" value = "Reserve">
</td>
<tr>

</table>  
</form>  
<tr><td><a href = "/catering_management/index.jsp">Logout</a></td></tr>
</html>